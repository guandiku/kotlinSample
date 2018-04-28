package com.xiamen.www.myapplication3.kotlin.javatest.handler;

/**
 * Created by White on 2018/4/28.
 */

public class Message {
    Handler target;
    public Object obj;
    public int what;

    @Override
    public String toString() {
        return   "what="+what+" obj="+obj.toString();
    }
}
