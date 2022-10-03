package com.kason.spring;

public class BeanDefinition {

    // 不确定类型，运行态才知道
    private Class<?> type;

    private String scope;

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
