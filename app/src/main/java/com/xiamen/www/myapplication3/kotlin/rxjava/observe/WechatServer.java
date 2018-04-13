package com.xiamen.www.myapplication3.kotlin.rxjava.observe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by White on 2018/3/13.
 * <p>
 * 具体的被观察者，也就是微信公众号服务
 */

public class WechatServer implements Observerable {

    private List<Observer> list;
    private String message;

    public WechatServer() {
        list = new ArrayList<>();
    }


    @Override
    public void register(Observer o) {
        list.add(o);
    }

    @Override
    public void removeRegister(Observer o) {
        if (!list.isEmpty()) {
            list.remove(o);
        }
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : list) {
            observer.update(message);
        }
    }

    public void setInformation(String s){
        this.message=s;
        System.out.println("微信服务更新消息:"+s);
        notifyObserver();
    }
}
