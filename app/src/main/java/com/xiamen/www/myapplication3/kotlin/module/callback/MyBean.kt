package com.xiamen.www.myapplication3.kotlin.module.callback

/**
 * Created by White on 2018/3/21.
 */
class MyBean {

    fun testCallBack1(callBack:(String) ->Unit){
        callBack.invoke("这是回调的内容")
    }


    fun testCallBack2(value1 :Int,value2:Int,callBack:(Int,Int)->Int):Int{
        var result=callBack.invoke(value1,value2)
        return result *3
    }

}

fun main(args: Array<String>) {
    val bean =MyBean()
    bean.testCallBack1 {
        println(it)
    }


    val result=bean.testCallBack2(1,2,{a,b ->
        a + b
    })
    println("计算结果"+result.toString())
}