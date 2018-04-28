package com.xiamen.www.myapplication3.kotlin.javatest.duotai;

import com.xiamen.www.myapplication3.kotlin.module.bean.A;

/**
 * Created by White on 2018/4/22.
 */

public class Cat extends Animal {
    @Override
    void eat() {
        System.out.println("猫吃鱼");
    }

    @Override
    Animal returnThis() {
        return this;
    }


    public void catchMouse(){
        System.out.println("猫抓老鼠");
    }
}
