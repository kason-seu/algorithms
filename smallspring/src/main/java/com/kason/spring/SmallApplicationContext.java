package com.kason.spring;

import com.kason.service.AppConfig;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class SmallApplicationContext {

    private Class<?> appConfig;

    private ConcurrentMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

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
                            Component componentAnnotation = clazz.getDeclaredAnnotation(Component.class);
                            String clazzName = componentAnnotation.value();
                            System.out.println("clazzName " + clazzName);

                            BeanDefinition beanDefinition = new BeanDefinition();

                            beanDefinition.setType(clazz);

                            Scope scopeAnnotation = clazz.getDeclaredAnnotation(Scope.class);

                            if (StringUtils.isBlank(scopeAnnotation.value()) ) {

                                beanDefinition.setScope("singleton");

                            } else {
                                beanDefinition.setScope(scopeAnnotation.value());
                            }

                            beanDefinitionMap.put(clazzName, beanDefinition);

                            return beanDefinition;
                        })
                        .collect(Collectors.toList());

                beanDefinitions.forEach(System.out::println);
            }


        }




    }

    public Object getBean(String beanName) {
        // 首先要知道bean的名字，才能生成这个bean，其次就是怎么确定这个类是单例还是多例那就需要新的注解@scope
        // 但是不能一个类上有多个注解，都要走一遍解析，这样太麻烦了，因此需要一个BeanDefinition 专门表达Bean创建的一些条件情况
        return null;
    }
}

