package com.xiamen.www.myapplication3.kotlin.javatest.design_pattern.singel;

import android.hardware.display.DisplayManager;
import android.support.v4.hardware.display.DisplayManagerCompat;

/**
 * Created by White on 2018/4/27.
 * <p>
 * DCL在高并发的情况下会出现失效问题，所以建议使用静态内部类的方式，
 * <p>
 * 静态内部类
 */

public class SingleInstance4 {
    private SingleInstance4() {
    }

    //单一全局访问点
    public static SingleInstance4 SingleInstance4() {

        return SingleInstance4Holder.mInstance;
    }

    //静态内部类，第一次加载SingleInstance4的时候不会初始化mInstance

    //    可以看到，当调用getInstance()方法时，
    // jvm才会加载SingletonHolder内部类，
    // 能确保线程安全，还能够保证对象的唯一性，没有上述3种实现方式的缺点。
    private static class SingleInstance4Holder {
        private static final SingleInstance4 mInstance = new SingleInstance4();
    }
}
