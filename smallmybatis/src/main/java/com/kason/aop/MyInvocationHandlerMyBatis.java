package com.kason.aop;

import com.kason.annotations.ExtInsert;
import com.kason.annotations.ExtParam;
import com.kason.annotations.ExtSelect;
import com.kason.utils.JDBCUtils;
import com.kason.utils.SQLUtils;
import com.kason.utils.Tuple2;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyInvocationHandlerMyBatis implements InvocationHandler {


    private Object instance;

    public MyInvocationHandlerMyBatis(Object instance) {
        this.instance = instance;
    }

    // proxy 代理对象， method 接口方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("在调用接口方法之前，先调用了动态代理部分的逻辑");

        // 1。 先判断该方法是不是有@ExtInsert注解
        boolean existsExtInsertAnnotation = method.isAnnotationPresent(ExtInsert.class);
        if (existsExtInsertAnnotation) {
            return exeInsertWithAnnotation(method, args);
        }
        // Select逻辑
        boolean existsExtSelectAnnotation = method.isAnnotationPresent(ExtSelect.class);
        if (existsExtSelectAnnotation) {
            // 2 获取注解value 即SQL语句
            ExtSelect extSelectAnnotation = method.getAnnotation(ExtSelect.class);
            String selectSql = extSelectAnnotation.value();
            System.out.println("sql : " + selectSql);

            // 3 获取入参以及SQL里面的参数匹配绑定
            Map<String, Object> paramsMap = getBindParamsKV(method, args);
            // 4 将SQL里#{}替换成?
            Tuple2<List<String>, String> sqlTransferAns = SQLUtils.sqlMatchSharpTransferToQuestionCombine(selectSql);
            List<Object> paramsValue = getExeSQLValues(paramsMap, sqlTransferAns);
            // 5 执行JDBC操作

            String newExeSql = sqlTransferAns.getRight();
            Class<?> returnType = method.getReturnType();
            // 返回的是List对象
            if (List.class.isAssignableFrom(returnType)) {
                System.out.println("Query的是List对象");

                // 方法的泛型，List<XXX>中的XXX
                Type genericReturnType = method.getGenericReturnType();

                System.err.println("genericReturnType:" + genericReturnType);
                Type trueType = ((ParameterizedType) genericReturnType).getActualTypeArguments()[0];
                //trueType就是泛型的真实类型
                return JDBCUtils.queryForList(newExeSql, (Class)trueType, paramsValue);
            } else {  // 返回的是普通对象
                System.out.println("Query的是单个对象");
                return JDBCUtils.queryForList(newExeSql, returnType, paramsValue).get(0);
            }
        }
        return null;
    }

    private int exeInsertWithAnnotation(Method method, Object[] args) {
        // 2 获取注解value 即SQL语句
        ExtInsert extInsertAnnotation = method.getAnnotation(ExtInsert.class);
        String insertSql = extInsertAnnotation.value();
        System.out.println("sql : " + insertSql);
        // 3 获取入参以及SQL里面的参数匹配绑定
        Map<String, Object> paramsMap = getBindParamsKV(method, args);
        // 4 将SQL里#{}替换成?
        Tuple2<List<String>, String> sqlTransferAns = SQLUtils.sqlMatchSharpTransferToQuestionCombine(insertSql);
        List<Object> paramsValue = getExeSQLValues(paramsMap, sqlTransferAns);
        // 5  执行JDBCUtils执行语句
        return JDBCUtils.updateV2(sqlTransferAns.getRight(), paramsValue);
    }

    private Map<String, Object> getBindParamsKV(Method method, Object[] args) {
        Map<String, Object> paramsMap = new HashMap<>();
        Parameter[] methodParameters = method.getParameters();
        // 传入的是对象
        if (methodParameters.length == 1 && !methodParameters[0].isAnnotationPresent(ExtParam.class)) {
            // 反射
            Class<?> paramClassType = methodParameters[0].getType();
            Field[] declaredFields = paramClassType.getDeclaredFields();
            Object paramBeanObject = args[0];
            for (Field declaredField : declaredFields) {

                declaredField.setAccessible(true);
                String fieldName = declaredField.getName();
                try {
                    Object fieldValue = declaredField.get(paramBeanObject);
                    paramsMap.put(fieldName, fieldValue);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        } else { // 传入的是注解参数
            for (int i = 0; i < methodParameters.length; i++) {
                boolean existsExtParamAnnotation = methodParameters[i].isAnnotationPresent(ExtParam.class);
                if (existsExtParamAnnotation) {
                    ExtParam extParamAnnotation = methodParameters[i].getAnnotation(ExtParam.class);
                    String paramName = extParamAnnotation.value();
                    Object paramValue = args[i];
                    paramsMap.put(paramName, paramValue);
                }

            }
        }
        return paramsMap;
    }

    /**
     * SQL中那几个？需要替换成的真实值
     * @param paramsMap
     * @param sqlTransferAns
     * @return
     */
    private List<Object> getExeSQLValues(Map<String, Object> paramsMap, Tuple2<List<String>, String> sqlTransferAns) {
        List<Object> paramsValue = new ArrayList<>();
        List<String> paramsNames = sqlTransferAns.getLeft();
        if (paramsNames != null) {
            for (String paramsName : paramsNames) {
                paramsValue.add(paramsMap.get(paramsName));
            }
        }
        return paramsValue;
    }
}
