package com.xiamen.www.myapplication3.kotlin.javatest.design_pattern.builder.better;

import com.xiamen.www.myapplication3.kotlin.javatest.design_pattern.builder.protetype.Person;

/**
 * Created by White on 2018/4/27.
 *
 * 具体建造者类，就是前面的builder，只是它是实现了一个共同的Builder接口
 *
 * https://blog.csdn.net/hp910315/article/details/49405311
 */

public class ConcreteBuilder implements Builder{

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
