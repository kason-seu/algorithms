package com.kason.service;

import com.kason.spring.Autowired;
import com.kason.spring.BeanNameAware;
import com.kason.spring.Component;
import com.kason.spring.Scope;

@Component
@Scope("singleton")
public class UserService implements BeanNameAware {

    @Autowired
    private OrderService orderService;

    private String beanName;

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public void test() {
        System.out.println("这是一个测试类" + orderService);
    }
}
