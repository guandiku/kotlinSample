package com.xiamen.www.myapplication3.kotlin.javatest.design_pattern.builder.protetype;

/**
 * Created by White on 2018/4/27.
 */

public class Test {
    //它分为抽象建造者（Builder）角色、
    // 具体建造者（ConcreteBuilder）角色、
    // 导演者（Director）角色、
    // 产品（Product）角色四个角色。
    public static void main(String[] args) {
        Builder builder = new Builder();
        builder.setName("Mirhunna")
                .setAge(23);
        Person person = builder.create();

    }
}
