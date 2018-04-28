package com.xiamen.www.myapplication3.kotlin.javatest.design_pattern.factory.easyfactory;

/**
 * Created by White on 2018/4/27.
 */

public class Factory {

    public static Product create(String productName) {
        switch (productName) {
            case "A":
                return new ProductA();
            case "B":
                return new ProductB();
            default:
                return new ProductB();
        }
    }
}
