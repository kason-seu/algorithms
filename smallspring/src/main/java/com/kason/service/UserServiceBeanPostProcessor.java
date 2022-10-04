package com.kason.service;

import com.kason.spring.BeanPostProcessor;
import com.kason.spring.Component;

@Component
public class UserServiceBeanPostProcessor implements BeanPostProcessor {
    @Override
    public void processBeforeInitiallization(String beanName, Object bean) {
        if ("userService".equals(beanName)) {
            System.out.println("UserServiceBeanPostProcessor : " + "userservice Before");
        }
    }

    @Override
    public void processAfterInitialization(String beanName, Object bean) {
        if ("userService".equals(beanName)) {
            System.out.println("UserServiceBeanPostProcessor : " + "userservice After");
        }
    }
}
