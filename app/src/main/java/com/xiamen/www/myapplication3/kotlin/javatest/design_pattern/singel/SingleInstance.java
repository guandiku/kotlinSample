package com.xiamen.www.myapplication3.kotlin.javatest.design_pattern.singel;

/**
 * Created by White on 2018/4/22.
 *
 * 饿汉式 单例设计模式
 */

public class SingleInstance {

  public static final SingleInstance singleInstance=new SingleInstance();

  private SingleInstance(){}

  public static SingleInstance getSingleInstance(){
      return singleInstance;
  }



}
