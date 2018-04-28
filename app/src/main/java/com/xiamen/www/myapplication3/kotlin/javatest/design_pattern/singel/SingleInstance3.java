package com.xiamen.www.myapplication3.kotlin.javatest.design_pattern.singel;

/**
 * Created by White on 2018/4/22.
 * <p>
 * 线程安全且效率高(DCL-Double Check Lock)
 */

public class SingleInstance3 {

    //简单描述一下，改变一个变量的值，
    // 也就是主内存中的值，
    // 必须通过3个步骤：assign+store+write操作，
    // 读也是需要3个步骤：read+load+use。
    // 加上volatile关键字就可以保证按照顺序进行读写，并且每次读取都是从主内存中获取真实值。
    private static volatile SingleInstance3 singleInstance3;

    private SingleInstance3() {

    }

    public static SingleInstance3 getSingleInstance3() {
        //提高效率，不用每次都去判断锁
        if (singleInstance3 == null) {
            //解决线程同步的问题，判断是否有锁
            synchronized (SingleInstance3.class) {
                //懒加载
                if (singleInstance3 == null) {
                    singleInstance3 = new SingleInstance3();
                }
            }
        }
        return singleInstance3;
    }
}
