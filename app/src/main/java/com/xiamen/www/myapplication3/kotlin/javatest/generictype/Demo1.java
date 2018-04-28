package com.xiamen.www.myapplication3.kotlin.javatest.generictype;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by White on 2018/4/24.
 */

public class Demo1 {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList();
        arrayList.add("aaa");
//        arrayList.add(134);//编译阶段不会报错，运行的时候会报错 ， 所以为了解决这个问题，泛型在jdk1.5中应运而生

//        for (int i =0;i<arrayList.size();i++){
//            String item = (String) arrayList.get(i);
////            Log.d(;
//            System.out.println("泛型测试"+"：item = "+item);
//        }


        //特效
        List<String> stringArrayList = new ArrayList<>();
        List<Integer> integerArrayList = new ArrayList<>();
        Class stringClazz= stringArrayList.getClass();
        Class integerClass=integerArrayList.getClass();

//        System.out.println(stringClazz.toString() +"," + integerClass.toString());
        /*
        通过上面的例子可以证明，在编译之后程序会采取去泛型化的措施。
        也就是说Java中的泛型，只在编译阶段有效。
        在编译过程中，正确检验泛型结果后，会将泛型的相关信息擦出，并且在对象进入和离开方法的边界处添加类型检查和类型转换的方法。
        也就是说，泛型信息不会进入到运行时阶段。
         */

        if (stringArrayList.equals(integerArrayList)){
//            System.out.println("类型相同");
        }

        /*
        泛型的使用：
        泛型有三种使用方式，分别有：泛型类，泛型接口，泛型方法
         */

        //泛型的类型参数只能是类类型(包括自定义类)，不能是简单类型
        //穿UR的实参类型需与泛型的类型参数类型相同，即为Integer
        Generic<Integer> integerGeneric=new Generic<>(123456);

        //传入的实参类型需要与泛型的类型参数类型相同，即为String
        Generic<String> generic = new Generic<>("key_value");
        System.out.println("泛型测试：key is" + generic.getKey());
        System.out.println("泛型测试：key is" + integerGeneric.getKey());


        Generic generic1=new Generic("123");
        Generic generic2=new Generic(123);
        Generic generic3=new Generic(33.33);
        Generic generic4=new Generic(true);

    }
}
