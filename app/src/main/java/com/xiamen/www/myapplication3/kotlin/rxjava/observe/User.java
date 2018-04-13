package com.xiamen.www.myapplication3.kotlin.rxjava.observe;

/**
 * Created by White on 2018/3/13.
 * <p>
 * 具体的观察者
 */

public class User implements Observer{

    private String name;
    private String message;

    public User(String name) {
        this.name = name;
    }

    public User() {
    }


    @Override
    public void update(String message) {
        this.message=message;
        read();
    }


    public void read(){
        System.out.println(name+"收到推送消息:"+message);
    }


}
