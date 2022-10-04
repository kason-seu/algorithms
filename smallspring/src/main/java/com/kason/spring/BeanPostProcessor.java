package com.kason.spring;

public interface BeanPostProcessor {

    public void processBeforeInitiallization(String beanName, Object bean);

    public void processAfterInitialization(String beanName, Object bean);

}
