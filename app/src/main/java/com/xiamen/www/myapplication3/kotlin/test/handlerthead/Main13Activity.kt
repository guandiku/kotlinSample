package com.xiamen.www.myapplication3.kotlin.test.handlerthead

import android.os.*
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.xiamen.www.myapplication3.R
import com.xiamen.www.myapplication3.kotlin.module.callback.main
import kotlinx.android.synthetic.main.activity_main13.*

/**
 * https://blog.csdn.net/carson_ho/article/details/79285760
 *
 *
 * HandlerThread 的使用
 */
class Main13Activity : AppCompatActivity() {

    lateinit var mainHandler: Handler
    lateinit var workHandler: Handler

    //步骤1：创建HandlerThread实例对象

    val mHandlerThread: HandlerThread by lazy {
        //传入参数 = 线程名称  ，  作用 = 标记该线程
        HandlerThread("handlerThread")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main13)

        mainHandler = Handler()
        //步骤2：启动线程
        mHandlerThread.start()


        /**
         *  步骤3：创建工作线程Handler & 复写handleMessage()
         *  作用：关联HandlerThread的Looper对象，实现消息处理操作&与其它线程进行通信
         *  注：消息处理操作handleMessage的执行线程  = mHandlerThread所创建的工作线程中执行
         */
        workHandler = object : Handler(mHandlerThread.looper) {
            override fun handleMessage(msg: Message?) {
                if (msg == null) {
                    return
                } else {
                    when (msg.what) {
                    //消息1
                        1 -> {
                            SystemClock.sleep(1000)
                            mainHandler.post {
                                run {
                                    text1.text = "我喜欢学习"
                                }
                            }
                        }
                    //消息2
                        2 -> {
                            SystemClock.sleep(1000)
                            mainHandler.post {
                                run {
                                    text1.text = "我不喜欢学习"
                                }
                            }

                        }
                        else -> {
                            //呵呵
                        }

                    }
                }

            }
        }

        //步骤4：使用工作线程Handler向工作现场的消息队列发送消息
        //在工作线程中，当消息循环时取出对应消息 &在工作线程执行相关操作
        button1.setOnClickListener {
            val msg= Message.obtain()
            msg.what=1
            msg.obj = "A"
            workHandler.sendMessage(msg)
        }

        button2.setOnClickListener {
            // 通过sendMessage（）发送
            // a. 定义要发送的消息
            val msg = Message.obtain()
            msg.what = 2 //消息的标识
            msg.obj = "B" // 消息的存放
            // b. 通过Handler发送消息到其绑定的消息队列
            workHandler.sendMessage(msg)
        }

        button3.setOnClickListener {
            mHandlerThread.quit()
        }
    }


}
