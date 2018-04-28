package com.xiamen.www.myapplication3.kotlin.javatest.design_pattern.singel;

/**
 * Created by White on 2018/4/22.
 * 改进版的单例设计模式
 */

public class SingleInstance2 {
    public static SingleInstance2 singleInstane2 = null;

    private SingleInstance2() {
    }

    public static SingleInstance2 getSingleInstane2() {
        if (singleInstane2 == null) {
            singleInstane2 = new SingleInstance2();
        }
        return singleInstane2;
    }
}
