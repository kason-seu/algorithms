package com.kason.spring;

import com.kason.service.AppConfig;
import org.apache.commons.lang3.StringUtils;

import java.beans.Introspector;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class SmallApplicationContext {

    private Class<?> appConfig;

    private ConcurrentMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
    private ConcurrentMap<String , Object> singletonBeanMap = new ConcurrentHashMap<>();

    private List<BeanPostProcessor> beanPostProcessorList = new ArrayList<>();

    public SmallApplicationContext(Class<?> appConfig) {
        this.appConfig = appConfig;
        // 解析配置class，看看是否有ComponentScan注解
        // 解析componentScan --> 扫描路径 --> 扫描
        if (appConfig.isAnnotationPresent(ComponentScan.class)) {
            ComponentScan componentScanAnnotation = appConfig.getDeclaredAnnotation(ComponentScan.class);

            String beanClassPath = componentScanAnnotation.value(); // 拿到com.kason.service

            System.out.println(beanClassPath);

            // 装载classLoader
            ClassLoader classLoader = SmallApplicationContext.class.getClassLoader();


            String beanClassPathDirectory = beanClassPath.replace(".", "/");
            System.out.println(beanClassPathDirectory);


            URL resource = classLoader.getResource(beanClassPathDirectory);

            assert resource != null;
            File file = new File(resource.getFile());

            if (file.isDirectory()) {
                List<BeanDefinition> beanDefinitions = Arrays.stream(Objects.requireNonNull(file.listFiles()))
                        .filter(f -> {   //过滤出class文件
                            return f.getAbsolutePath().endsWith(".class");
                        })
                        .map(f -> { // 将文件目录的class名称转化为可装载的文件路径名
                            String classPath = f.getAbsolutePath();
                            classPath = classPath.substring(classPath.indexOf("com"), classPath.indexOf(".class"));
                            classPath = classPath.replace("/", ".");
                            return classPath;
                        })
                        .map(classPath -> {  // 装载bean
                            try {
                                return classLoader.loadClass(classPath);

                            } catch (ClassNotFoundException e) {
                                throw new RuntimeException(e);
                            }
                        })
                        .filter(clazz -> {  // 留下Component注解的类，这些类是应该实例化bean的
                            return clazz.isAnnotationPresent(Component.class);
                        })
                        .map(clazz -> {

                            if (BeanPostProcessor.class.isAssignableFrom(clazz)) {
                                try {
                                    beanPostProcessorList.add((BeanPostProcessor) clazz.getDeclaredConstructor().newInstance());
                                } catch (InstantiationException e) {
                                    throw new RuntimeException(e);
                                } catch (IllegalAccessException e) {
                                    throw new RuntimeException(e);
                                } catch (InvocationTargetException e) {
                                    throw new RuntimeException(e);
                                } catch (NoSuchMethodException e) {
                                    throw new RuntimeException(e);
                                }
                                return null;
                            }

                            Component componentAnnotation = clazz.getDeclaredAnnotation(Component.class);
                            String clazzName = componentAnnotation.value();
                            // 如果Component使用时，忘记了指定名称，那么我们将自动生成
                            if (StringUtils.isBlank(clazzName)) {

                                clazzName = Introspector.decapitalize(clazz.getSimpleName());
                            }
                            System.out.println("clazzName " + clazzName);

                            BeanDefinition beanDefinition = new BeanDefinition();

                            beanDefinition.setType(clazz);

                            Scope scopeAnnotation = clazz.getDeclaredAnnotation(Scope.class);

                            if (scopeAnnotation == null || StringUtils.isBlank(scopeAnnotation.value()) ) {

                                beanDefinition.setScope("singleton");

                            } else {
                                beanDefinition.setScope(scopeAnnotation.value());
                            }

                            beanDefinitionMap.put(clazzName, beanDefinition);

                            return beanDefinition;
                        })
                        .collect(Collectors.toList());

                beanDefinitions.forEach(System.out::println);

                // 初始化单例bean
                beanDefinitionMap.forEach((k,v) -> {
                    if ("singleton".equals(v.getScope())) {
                        Object createBean = createBean(k, v);
                        singletonBeanMap.put(k, createBean);
                    }
                });

                //
                System.out.println();
            }
        }

    }

    public Object getBean(String beanName) {
        // 首先要知道bean的名字，才能生成这个bean，其次就是怎么确定这个类是单例还是多例那就需要新的注解@scope
        // 但是不能一个类上有多个注解，都要走一遍解析，这样太麻烦了，因此需要一个BeanDefinition 专门表达Bean创建的一些条件情况
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new NullPointerException("不存在该bean");
        }
        String scope = beanDefinition.getScope();
        if ("singleton".equals(scope)) {
            Object bean = singletonBeanMap.get(beanName);
            if (bean == null) {
                Object createBean = createBean(beanName, beanDefinition);
                singletonBeanMap.put(beanName, createBean);
            }
            return bean;
        } else {
            return createBean(beanName, beanDefinition);
        }
    }

    private Object createBean(String beanName, BeanDefinition beanDefinition) {

        Class<?> clazz = beanDefinition.getType();
        final Object bean;
        try {
            // 该bean需要有无参构造函数
            bean = clazz.getConstructor().newInstance();
            // 装载bean对象里面的Field实例
            Field[] declaredFields = clazz.getDeclaredFields();
            Arrays.stream(declaredFields)
                    .filter(f -> f.isAnnotationPresent(Autowired.class))
                    .forEach(f -> {
                        String fieldName = f.getName();
                        System.out.println("FieldName : " + fieldName);
                        Object fieldBean = getBean(fieldName);
                        f.setAccessible(true);
                        try {
                            f.set(bean, fieldBean);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    });
            // 设置beanName. 通过Aware回调。回调接口Spring会主导做一些事情
            if (bean instanceof BeanNameAware) {
                ((BeanNameAware)bean).setBeanName(beanName);
            }

            beanPostProcessorList.forEach(beanPostProcessor -> {
                beanPostProcessor.processBeforeInitiallization(beanName, bean);
            });
            // 执行一个Bean的初始化逻辑
            if (bean instanceof InitialingBean) {
                ((InitialingBean)bean).afterPropertiesSet();
            }

            beanPostProcessorList.forEach(beanPostProcessor -> {
                beanPostProcessor.processAfterInitialization(beanName, bean);
            });
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return bean;
    }
}

