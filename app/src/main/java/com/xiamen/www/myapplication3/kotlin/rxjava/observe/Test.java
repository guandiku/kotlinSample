package com.xiamen.www.myapplication3.kotlin.rxjava.observe;

/**
 * Created by White on 2018/3/13.
 */

public class Test {
    public static void main(String[] args) {
            WechatServer server=new WechatServer();

            User user1=new User("user1");
            User user2=new User("user2");
            User user3=new User("user3");


                server.register(user1);
                server.register(user2);
                server.register(user3);

            server.setInformation("PHP是世界上最好的语言");

    }
}
