package com.xiamen.www.myapplication3.kotlin.javatest.threads;

/**
 * Created by White on 2018/4/22.
 * <p>
 * <p>
 * 生产和消费者的Demo
 */

class Resource {
    private String name;
    private int count = 1;
    private boolean flag = false;

    public synchronized void set(String name) {

        if (flag) {
            try {
                //t0
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name + count;
        count++;
        System.out.println(Thread.currentThread().getName() + "....生产者...." + this.name);
        flag = true;
        notify();
    }


    public synchronized void out() {
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "...消费者..." + this.name);
        flag = false;
        notify();
    }
}


class Producer implements Runnable {

    private Resource resource;

    Producer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {

        while (true) {
            resource.set("烤鸭");
        }
    }
}


class Consumer implements Runnable {
    private Resource resource;

    Consumer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true) {
            resource.out();
        }
    }
}

public class ProducerConsumerDemo {

    public static void main(String[] args) {
        Resource resource = new Resource();

        Producer pro = new Producer(resource);
        Producer pro2 = new Producer(resource);
        Producer pro3 = new Producer(resource);
        Consumer consumer = new Consumer(resource);
        Consumer consumer2 = new Consumer(resource);
        Consumer consumer3 = new Consumer(resource);

        Thread t1 = new Thread(pro);
        Thread t2 = new Thread(consumer);

        t1.start();
        t2.start();
    }

}
