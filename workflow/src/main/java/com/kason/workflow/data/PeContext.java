package com.kason.workflow.data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 串流程范围内的上下文
 */
public class PeContext {
    private Map<String, Object> info = new ConcurrentHashMap<>();

    public Object getValue(String key) {
        return info.get(key);
    }

    public void putValue(String key, Object value) {
        info.put(key, value);
    }
}
