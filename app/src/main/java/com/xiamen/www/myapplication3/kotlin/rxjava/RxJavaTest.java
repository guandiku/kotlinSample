package com.xiamen.www.myapplication3.kotlin.rxjava;


import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by White on 2018/3/10.
 *
 */

public class RxJavaTest {
    private static final String TAG = "RxJavaTest";

    public static void main(String[] args) {

//        //创建一个上游的Observable
//        Observable<Integer>   observable = Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
//                     emitter.onNext(1);
//                     emitter.onNext(2);
//                     emitter.onNext(3);
//                     emitter.onComplete();
//            }
//        });
//
//        //创建一个下游Observer
//        Observer<Integer> observer=new Observer<Integer>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                System.out.println("subscribe");
//            }
//
//            @Override
//            public void onNext(Integer value) {
//                System.out.println(TAG+":"+value);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                System.out.println(TAG+":"+e);
//            }
//
//            @Override
//            public void onComplete() {
//                System.out.println(TAG+":complete");
//            }
//        };
//
//        //建立联系
//        observable.subscribe(observer);


        //把上面的代码连接起来使用就成为了RxJava引以为傲的链式操作
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                //Observable：Emitter 发射器，发出时间
//                e.onNext(1);
//                e.onNext(2);
//                e.onNext(3);
//                e.onComplete();
//            }
//        }).subscribe(new Observer<Integer>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                //Disposable 一次性用品
//            }
//
//            @Override
//            public void onNext(Integer value) {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });

//
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                e.onNext(1);
//                e.onNext(2);
//                e.onNext(3);
//            }
//        }).map(new Function<Integer, String>() {
//            @Override
//            public String apply(Integer integer) throws Exception {
//                return "This is result "+integer;
//            }
//        }).subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
////                Log.d(TAG,s);
//                System.out.println(TAG+s);
//            }
//        });

//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                e.onNext(1);
//                e.onNext(2);
//                e.onNext(3);
//            }
//        }).concatMap(new Function<Integer, ObservableSource<String>>() {
//            @Override
//            public ObservableSource<String> apply(Integer integer) throws Exception {
//                final List<String> list=new ArrayList<>();
//                for (int i=0;i<3;i++){
//                    list.add("I am value "+integer);
//                }
//                return Observable.fromIterable(list);
//            }
//        }).subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                System.out.println(TAG+s);
//            }
//        });




    }
}
