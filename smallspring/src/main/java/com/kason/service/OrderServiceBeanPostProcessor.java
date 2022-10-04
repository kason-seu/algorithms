package com.kason.service;

import com.kason.spring.BeanPostProcessor;
import com.kason.spring.Component;

@Component
public class OrderServiceBeanPostProcessor implements BeanPostProcessor {
    @Override
    public void processBeforeInitiallization(String beanName, Object bean) {
        if ("orderService".equals(beanName)) {
            System.out.println("OrderServiceBeanPostProcessor : " + "orderService Before");
        }
    }

    @Override
    public void processAfterInitialization(String beanName, Object bean) {
        if ("orderService".equals(beanName)) {
            System.out.println("OrderServiceBeanPostProcessor : " + "orderService After");
        }
    }
}
