package com.xiamen.www.myapplication3.kotlin.javatest.duotai;

/**
 * Created by White on 2018/4/22.
 */

public class Dog extends Animal<Dog> {
    @Override
    void eat() {
        System.out.println("狗吃骨头");
    }

    @Override
    Dog returnThis() {
        return this;
    }


    public void play() {
        System.out.println("狗做游戏"
        );
    }
}
