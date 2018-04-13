package com.xiamen.www.myapplication3.kotlin.module.callback

/**
 * Created by White on 2018/3/21.
 */
class PersonKotl {
    val name: String = "Person"
    lateinit var mListen: (String) -> Unit //声明mListen是一个函数(单方法接口)，入参String，无返回值

    fun setListener(listener: (String) -> Unit) {
        this.mListen = listener
        this.mListen("invoke:" + name) //等于 mListen?.invoke("invoke:"+name) X()等同于X.invoke()
    }

    //不再需要声明接口类!

}


fun main(args: Array<String>) {
    println("Hello world")
    val personkotl = PersonKotl()
    personkotl.setListener {
        println(it)
    }


}

