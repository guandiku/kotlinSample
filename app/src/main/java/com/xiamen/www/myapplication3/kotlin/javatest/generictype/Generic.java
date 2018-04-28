package com.xiamen.www.myapplication3.kotlin.javatest.generictype;

/**
 * Created by White on 2018/4/24.
 */

//此处的T可以随便写为任意标识，常见的如T,E,K,V等形式的参数常用于表示泛型
//在实例化泛型类时候，必须指定T的具体类型
public class Generic<T> {
    //key这个成员变量的类型为T，T的类型由外部指定
    private T key;

    public Generic(T t) {
        this.key = t;
    }

    public T getKey() {
        return key;
    }
}
