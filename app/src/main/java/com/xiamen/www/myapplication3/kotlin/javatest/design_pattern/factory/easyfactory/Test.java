package com.xiamen.www.myapplication3.kotlin.javatest.design_pattern.factory.easyfactory;

/**
 * Created by White on 2018/4/27.
 */

public class Test {
    public static void main(String[] args) {
        //生产A
        Product productA = Factory.create("A");
        productA.show();

    }
}
