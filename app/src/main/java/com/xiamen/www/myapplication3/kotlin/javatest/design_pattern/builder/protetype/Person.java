package com.xiamen.www.myapplication3.kotlin.javatest.design_pattern.builder.protetype;

/**
 * Created by White on 2018/4/27.
 */

public class Person {
    private String name;
    private boolean sex;
    private int age;
    private float height;
    private float weight;


    public Person(String name, boolean sex, int age, float height, float weight) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }
}
