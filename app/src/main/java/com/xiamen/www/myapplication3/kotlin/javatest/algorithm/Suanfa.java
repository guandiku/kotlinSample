package com.xiamen.www.myapplication3.kotlin.javatest.algorithm;

import android.view.View;

import java.util.Arrays;

/**
 * Created by White on 2018/4/22.
 * <p>
 * 两种冒泡方法的写法 求最大值 打印99乘法表 求100以内所有的质数
 */

public class Suanfa {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 3, 432, 543, 65, 7};

        for (int i = 0; i < array.length - 1; i++) {
            for (int y = 0; y < array.length - 1 - i; y++) {
                if (array[y + 1] > array[y]) {
                    int temp = array[y];
                    array[y] = array[y + 1];
                    array[y + 1] = temp;
                }
            }

        }

//        System.out.println(Arrays.toString(array));

        for (int x = array.length - 1; x > 0; x--) {
            for (int y = 0; y < x; y++) {
                if (array[y] > array[y + 1]) {
                    int temp = array[y];
                    array[y] = array[y + 1];
                    array[y + 1] = temp;
                }
            }
        }

//        System.out.println(Arrays.toString(array));


        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
//                System.out.print(i+"*"+j+"="+i*j+"\t");
            }
//            System.out.println("");
        }


        int a[][] = new int[10][10];
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                a[i][j] = i * j;
//                System.out.print(i+"*"+j+"="+a[i][j]+"\t");
            }
//            System.out.println("");
        }


        int[] aaa = {1, 2, 3, 4, 5, 6, 7, 8, 4, 3, 2, 10};
        int max = aaa[0];
        for (int i = 0; i < aaa.length; i++) {
            if (max < aaa[i]) {
                max = aaa[i];
            }
        }
//        System.out.println("最大值为:"+max);


        //求100以内所有的质数
        //  https://blog.csdn.net/askmufei/article/details/8821189
        boolean bool;
        for (int i = 3; i < 100; i+=2) {
            bool = true;
            for (int j = 3; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    bool = false;
                    break;
                }
            }
            if (bool)
                System.out.print(i + " ");
        }

        //多生产者多消费者问题

//        View.MeasureSpec.AT_MOST

    }


}
