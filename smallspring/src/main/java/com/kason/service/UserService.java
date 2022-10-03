package com.kason.service;

import com.kason.spring.Autowired;
import com.kason.spring.Component;
import com.kason.spring.Scope;

@Component
@Scope("singleton")
public class UserService {

    @Autowired
    private OrderService orderService;


    public void test() {
        System.out.println("这是一个测试类" + orderService);
    }
}
