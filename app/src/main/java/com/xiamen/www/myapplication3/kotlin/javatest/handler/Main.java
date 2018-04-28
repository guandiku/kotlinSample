package com.xiamen.www.myapplication3.kotlin.javatest.handler;


/**
 * Created by White on 2018/4/28.
 */

public class Main {
    public static void main(String[] args) {
        new Main().start();
    }

    private void start() {
        //创建该线程唯一的消息队列，线程安全的阻塞队列
        Looper.prepare();
        onCreate();

        //死循环，阻塞式，
        // 执行下面代码后主线程就会去获取消息队列里的消息，
        // 没有消息时就阻塞
        // ，有就执行。执行Looper.loop前即使消息队列里有消息，消息也不会执行，因为主线程还没有去检查消息队列。
        Looper.loop();

        //下面 的代码通常不会执行，
        // 除非手动让主线程消息队列退出。
        // 退出主线程消息队列后android的view布局、绘制，事件分发就不执行了，
        // 所以android APP也没必要继续执行了，
        // 所以android采用了抛出异常的方式结束APP。
        System.out.println("exit........");
        throw new RuntimeException("Main thread loop unexpectedly exited");

    }

    private void onCreate() {
        //下面操作相当与在android的UI线程中进行
        final Thread thread = Thread.currentThread();
        System.out.println("main thread = " + thread);

        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                //若thread == Thread.currentThread() ，则证明已经运行在主线程
                System.out.println("current thread is main thread?" + Thread.currentThread());
                super.handleMessage(msg);
                System.out.println();
            }
        };

        // 测试1       主线程创建handler，子线程使用该handler发送消息
        new Thread() {
            public void run() {
                try {//模拟耗时操作
                    Thread.sleep(1000 * 2);
                } catch (InterruptedException e) {
                }
                Message message = new Message();
                message.obj = "new Thread" + Thread.currentThread();
                message.what = (int) System.currentTimeMillis();
                //在子线程中发送消息
                handler.sendMessage(message);

                try {
                    Thread.sleep(1000 * 2);
                } catch (InterruptedException e) {
                }

                message = new Message();
                message.obj = "hanler...waht==1" ;
                message.what = 1;
                //在子线程中发送消息
                handler.sendMessage(message);

                message = new Message();
                message.obj = "hanler...waht==2" ;
                message.what = 2;
                //在子线程中发送消息
                handler.sendMessage(message);

                message = new Message();
                message.obj = "hanler...waht==3" ;
                message.what = 3;
                //在子线程中发送消息
                handler.sendMessage(message);

            };
        }.start();

        // 测试2 在thread内部创建handler，结果会抛出异常
//        new Thread() {
//            public void run() {
//                try {
//                    sleep(1000 * 3);
//                } catch (InterruptedException e) {
//                }
//				/*
//				 * 在线程内部使用默认构造函数创建handler会抛出异常。
//				 * android中也可以在子线程中创建Handler，但要在初始化时传入Looper，
//				 * Looper.getMainLooper()获取到的就是主线程的Looper，所以可以这样创建
//				 *
//				 * new Handler(Looper.getMainLooper()){
//						@Override
//						public void handleMessage(Message msg) {
//							//运行在主线程中
//						}
//					};
//				 */
//                Handler h = new Handler() {
//                    public void handleMessage(Message msg) {
//                        System.out.println("haneler msg...." + msg);
//                    };
//                };
//                Message message = new Message();
//                message.obj = "handler in new Thread";
//                message.what = (int) System.currentTimeMillis();
//                //在子线程中发送消息
//                h.sendMessage(message);
//            };
//        }.start();
        //////////////////////////////////////////////////////////
        ////// 上面的操作相当于运行在android的UI线程中 ////////////
        //////////////////////////////////////////////////////////

    }
}
