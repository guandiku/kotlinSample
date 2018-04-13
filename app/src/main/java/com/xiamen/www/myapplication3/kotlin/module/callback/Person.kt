package com.xiamen.www.myapplication3.kotlin.module.callback

/**
 * Created by White on 2018/3/21.
 */
class Person {

    val name: String = "Person"
    lateinit var mListen: MyInterface

    fun setListener(listen: MyInterface) {
        this.mListen = listen
        this.mListen.poo("poo" + name)
    }

    interface MyInterface {
        fun poo(str: String)
    }
}


fun main(args: Array<String>) {
    println("Hello world")
    val person = Person()
    person.setListener(object : Person.MyInterface {
        override fun poo(str: String) {
            println(str)
        }

    })
}