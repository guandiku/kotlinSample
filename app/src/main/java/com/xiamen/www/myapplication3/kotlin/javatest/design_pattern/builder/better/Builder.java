package com.xiamen.www.myapplication3.kotlin.javatest.design_pattern.builder.better;

import com.xiamen.www.myapplication3.kotlin.javatest.design_pattern.builder.protetype.Person;

/**
 * Created by White on 2018/4/27.
 *
 * 抽象建造者类B
 */

public interface Builder {
     Builder setName(String name);

     Builder setSex(boolean sex);

     Builder setAge(int age);

     Builder setHeight(float height);

     Builder setWeight(float weight);

     Person create();
}
