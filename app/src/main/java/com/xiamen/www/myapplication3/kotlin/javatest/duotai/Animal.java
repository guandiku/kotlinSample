package com.xiamen.www.myapplication3.kotlin.javatest.duotai;

/**
 * Created by White on 2018/4/22.
 */

public abstract class Animal<T extends Animal> {

    abstract void eat();

    abstract T returnThis();

}
