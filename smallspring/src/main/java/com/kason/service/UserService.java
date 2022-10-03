package com.kason.service;

import com.kason.spring.*;

@Component
@Scope("singleton")
public class UserService implements BeanNameAware, InitialingBean {

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

    @Override
    public void afterPropertiesSet() {
        // 执行逻辑
        System.out.println("这是初始化时候调用的方法，用户随便做什么,Spring只管调，不管其他的");
    }
}
