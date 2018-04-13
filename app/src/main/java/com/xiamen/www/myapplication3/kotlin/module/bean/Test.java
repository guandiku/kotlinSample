package com.xiamen.www.myapplication3.kotlin.module.bean;

import com.xiamen.www.myapplication3.kotlin.module.Fruit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by White on 2018/3/17.
 */

public class Test {
    public static void main(String[] args) {
        List<? super Fruit> list=new ArrayList<>();
        list.add(new A());
        list.add(new B());


//        List<? extends Fruit> list2=new ArrayList<>();
//        list2.add(new A());
    }
}
