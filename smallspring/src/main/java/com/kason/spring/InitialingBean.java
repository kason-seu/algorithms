package com.kason.spring;

// 初始化接口，Spring只负责call这个接口，至于用户干什么Spring不管
public interface InitialingBean {

    public void afterPropertiesSet();

}
