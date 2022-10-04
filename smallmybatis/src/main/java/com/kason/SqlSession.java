package com.kason;

import com.kason.aop.MyInvocationHandlerMyBatis;

import java.lang.reflect.Proxy;

public class SqlSession {

    public static <T> T getMapper(Class<T> clazz) {

        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new MyInvocationHandlerMyBatis(clazz));

    }
}
