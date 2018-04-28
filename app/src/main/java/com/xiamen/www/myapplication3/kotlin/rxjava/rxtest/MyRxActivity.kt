package com.xiamen.www.myapplication3.kotlin.rxjava.rxtest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.xiamen.www.myapplication3.R
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * Created by White on 2018/3/20.
 */
class MyRxActivity : AppCompatActivity() {

    val TAG = this.javaClass.canonicalName


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_rxjava)


        Observable.create(ObservableOnSubscribe<Int> { e ->
            e.onNext(1)
            e.onNext(2)
            e.onNext(3)
            e.onNext(4)
            e.onComplete()
        }).subscribe {
            //            Log.e(TAG, it.toString())
        }


//        val observer= object:Observer<Int>{
//            override fun onComplete() {
//                Log.e(TAG,"onComplete")
//            }
//
//            override fun onSubscribe(d: Disposable) {
//                Log.e(TAG,"onSubscribe")
////                d.dispose()
//            }
//
//            override fun onNext(t: Int) {
//                Log.e(TAG,"onNext $t")
//            }
//
//            override fun onError(e: Throwable) {
//            Log.e(TAG,"onError")
//            }
//
//        }
//
//        observable.subscribe(observer)

        Observable.interval(2, TimeUnit.SECONDS)
                .subscribe {
                    //                    Log.e(TAG,it.toString())
                }


        Observable.just(1, 2, 3)
                .map {
                    it + 3
                }.subscribe {
                    //                    Log.e(TAG,it.toString())
                }

        /**
         * 练习时间
         */


        val student1 = Student(19, "小强19")
        val student2 = Student(20, "小强20")
        val student3 = Student(21, "小强21")
        val student4 = Student(22, "小强22")
        val student5 = Student(23, "小强23")
        val student6 = Student(24, "小强24")
        val student7 = Student(25, "小强25")
        val student8 = Student(26, "小强26")
        val student9 = Student(27, "小强27")
        val student10 = Student(28, "小强28")
        var i = 0
        val list: List<Student> = listOf(student1, student2, student3, student4, student5, student6, student7, student8, student9, student10)
        Observable.just(list)
                .flatMap {
                    Observable.fromIterable(list)
                }
                .distinct()
                .filter {
                    it.age >= 20
                }.map {
                    it.name
                }
                .subscribe {
                    i++
//                    Log.e(TAG,it)
                }
//        Log.e(TAG,"年龄大于20的人数有${i}个")


        /**
         * 一些时间格式的用法
         *
         * NANOSECONDS   毫微秒  十亿分之一秒（就是微秒/1000）
         * MICROSECONDS    微秒   一百万分之一秒（就是毫秒/1000）
         * MILLISECONDS    毫秒   千分之一秒
         * SECONDS          秒
         * MINUTES        分钟
         * HOURS          小时
         * DAYS            天
         */


        //时间间隔输出字符串
        val list2: List<String> = listOf("one", "two", "three", "four", "five")
        Observable.interval(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    for (i in list2) {
//                        Thread.sleep(1000)
//                        Log.e(TAG, i)
                    }
                }

        /**
         * map修饰符
         */
        Observable.create<Int> { it ->
            it.onNext(1)
            it.onNext(2)
            it.onNext(3)
        }.map {
                    //                    "${it}变化了"
                }
                .subscribe { Log.e(TAG, it.toString()) }

        /**
         * flatMap修饰符
         */
        Observable.create<Int> {
            it.onNext(1)
            it.onNext(2)
            it.onNext(3)
            it.onNext(4)
            it.onNext(5)
            it.onNext(6)
            it.onNext(7)
            it.onNext(8)
        }.flatMap {
                    val list: MutableList<String> = ArrayList()
                    list.add("I am value " + it)
                    //随机生成一个时间
                    val delayTime = (1 + Math.random() * 10).toLong()
                    Observable.fromIterable(list).delay(delayTime, TimeUnit.MILLISECONDS)
                }.subscribe {
                    //                    Log.e(TAG, it)
                }

        /**
         * ConcatMap操作符
         */
        Observable.create<Int> {
            it.onNext(1)
            it.onNext(2)
            it.onNext(3)
            it.onNext(4)
            it.onNext(5)
            it.onNext(6)
            it.onNext(7)
            it.onNext(8)
        }.concatMap {
                    val list: MutableList<String> = ArrayList()
                    list.add("I am value " + it)
                    //随机生成一个时间
                    val delayTime = (1 + Math.random() * 10).toLong()
                    Observable.fromIterable(list).delay(delayTime, TimeUnit.MILLISECONDS)
                }.subscribe { }


        /**
         * zip操作符
         */
        val observable = Observable.create<Int> {
            it.onNext(1)
        }

        val observable1 = Observable.create<Int> {
            it.onNext(2)
        }


        Observable.zip(observable, observable1, BiFunction<Int, Int, String> { t1, t2 ->
            (t1 + t2).toString()
        }).subscribe {
            //                            Log.e(TAG,"组合之后是:"+it)
        }


        /**
         * interval 操作符
         */
        //方法1
        Flowable.interval(1, TimeUnit.SECONDS)
                .subscribe {
                    //                    Log.e(TAG,it.toString())
                }

        //方法2
        Observable.interval(1, TimeUnit.SECONDS)
                .subscribe {
                    //                    Log.e(TAG,it.toString())
                }

        /**
         * time 操作符
         */
        Observable.timer(2, TimeUnit.SECONDS)
                .subscribe {
                    print("两秒之后才开始执行的操作")
                }


        /**
         * 实现倒计时方法
         */
        countDown(5).subscribe {
            //            Log.e(TAG,it.toString())
        }

        /**
         * repeat操作符：重复的发射数据
         */

        Observable.just(1, 2)
                .repeat(3)
                .subscribe {
                    //                    Log.e(TAG,it.toString())
                }
        /**
         * 发送特定的整数数列
         */
        Observable.range(1, 5)
                .repeat(3)
                .subscribe { }

        /**
         * 遍历数组
         */
        var array1: IntArray = intArrayOf(1, 2, 3)
        Observable.fromArray(array1)
                .subscribe {
                    //                    print(it)
                }


        /**
         * 遍历集合
         */
        val list3: List<String> = listOf("a", "b", "c")
        Observable.fromIterable(list3)
                .subscribe {
                    //                    for (i in it){
//                        println(i)
//                    }
//                    println(it)
                }

//        /**
//         * toList:把数据转换成List集合
//         */
//        Observable.range(1,7)
//                .toList()
//

        /**
         * delay 延迟发射数据
         */
        Observable.just(1, 2, 3)
                .delay(3, TimeUnit.SECONDS)
                .subscribe {
                    println(it)
                }

        /**
         * 背压
         */
        Observable.interval(1, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .subscribe {
                    //                    Thread.sleep()
                }


        /**
         * Rxjava遍历,过滤集合
         */
        val userList: MutableList<User> = ArrayList()
        (1..10).mapTo(userList) { User("${it}") }

        Observable.fromIterable(userList)
                .filter {
                    it.id == "2"
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    println(it.id)
                }

    }


    private fun countDown(time: Long): Observable<Long> {
        return Observable.interval(1, TimeUnit.SECONDS)
                .map {
                    time - it
                }.take(time + 1)
    }


    data class Student(var age: Int, var name: String)
    data class User(var id: String)

}
