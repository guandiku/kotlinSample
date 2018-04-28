package com.xiamen.www.myapplication3.kotlin.javatest.design_pattern.builder.protetype;

/**
 * Created by White on 2018/4/27.
 */

public class Builder {
    private String name;
    private boolean sex;
    private int age;
    private float height;
    private float weight;

    public Builder setName(String name) {
        this.name = name;
        return this;
    }

    public Builder setSex(boolean sex) {
        this.sex = sex;
        return this;
    }

    public Builder setAge(int age) {
        this.age = age;
        return this;
    }

    public Builder setHeight(float height) {
        this.height = height;
        return this;
    }

    public Builder setWeight(float weight) {
        this.weight = weight;
        return this;
    }

    public Person create() {
        return new Person(name, sex, age, height, weight);
    }
}
