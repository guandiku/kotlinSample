package com.xiamen.www.myapplication3.kotlin.javatest.handler;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by White on 2018/4/28.
 */

public class ThreadLocal<T> {
    private Map<Thread,T> map;

    public ThreadLocal() {
        map=new HashMap<>();
    }

    public void set(T obj) {
        map.put(Thread.currentThread(),obj);
    }

    public T get() {
        return map.get(Thread.currentThread());
    }
}
