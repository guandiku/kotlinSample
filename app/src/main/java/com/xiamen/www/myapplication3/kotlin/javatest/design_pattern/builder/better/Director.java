package com.xiamen.www.myapplication3.kotlin.javatest.design_pattern.builder.better;

/**
 * Created by White on 2018/4/27.
 */

public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct(String name, boolean sex, int age, float height, float weight) {
        builder.setName(name)
                .setAge(age)
                .setHeight(height)
                .setSex(sex)
                .setWeight(weight)
                .create();
    }
}
