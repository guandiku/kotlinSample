package com.xiamen.www.myapplication3.kotlin.rxjava.observe;

/**
 * Created by White on 2018/3/13.
 *
 * 抽象被观察者接口
 */

public interface Observerable {
    void register(Observer o);
    void removeRegister(Observer o);
    void notifyObserver();

}
