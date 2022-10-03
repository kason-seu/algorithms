package com.kason.app;

import com.kason.service.AppConfig;
import com.kason.spring.SmallApplicationContext;

public class Test {


    public static void main(String[] args) {
        SmallApplicationContext smallApplicationContext = new SmallApplicationContext(AppConfig.class);

        System.out.println(smallApplicationContext.getBean("userService"));
        System.out.println(smallApplicationContext.getBean("userService"));
        System.out.println(smallApplicationContext.getBean("userService"));
        System.out.println(smallApplicationContext.getBean("userService"));
    }
}
