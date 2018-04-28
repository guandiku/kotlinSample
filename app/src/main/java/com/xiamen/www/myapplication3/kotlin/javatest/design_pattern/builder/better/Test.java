package com.xiamen.www.myapplication3.kotlin.javatest.design_pattern.builder.better;

import com.xiamen.www.myapplication3.kotlin.javatest.design_pattern.builder.protetype.Person;

/**
 * Created by White on 2018/4/27.
 */

public class Test {
    //它分为抽象建造者（Builder）角色、
    // 具体建造者（ConcreteBuilder）角色、
    // 导演者（Director）角色、
    // 产品（Product）角色四个角色。
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director pcDirector = new Director(builder);
        pcDirector.construct("Mirhunana", true, 23, 180, 100);

    }
}
