package com.xiamen.www.myapplication3.kotlin.kotlintest

/**
 * Created by White on 2018/5/16.
 */
class Test1 {
    fun main(args: Array<String>) {
        //lambda表达式
        val sum1 = { x: Int, j: Int -> x + j }
//        1. lambda 表达式总是被大括号括着；
//        2. 其参数（如果有的话）在 -> 之前声明（参数类型可以省略）；
//        3. 函数体（如果存在的话）在 -> 后面
        val sum2: (x: Int, j: Int) -> Int = { a, b -> a + b }
        /**
         *高阶函数：以函数作为参数或者返回函数的函数称为高阶函数
         * 定义一个高阶函数：
         * fun 高阶函数名(参数函数名：参数函数类型)：高阶函数返回类型{
        高阶函数体
        ...
        }
         */

        val sum3 = { x: Int, y: Int -> x + y }

        val max = { x: Int, y: Int -> x > y }

        val biggerNum = highOrderFunc(60, 50, max)

        print(biggerNum)
    }


    private fun highOrderFunc(arg1: Int, arg2: Int, paramFunc: (a: Int, b: Int) -> Boolean): Int {
        return if (paramFunc(arg1, arg2)) {
            arg1
        } else {
            arg2
        }
    }
}