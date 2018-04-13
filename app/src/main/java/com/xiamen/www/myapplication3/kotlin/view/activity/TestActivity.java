package com.xiamen.www.myapplication3.kotlin.view.activity;

import android.util.Log;

import com.xiamen.www.myapplication3.R;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by White on 2018/3/10.
 */

public class TestActivity extends BaseActivity {
    private static final String TAG = "TestActivity";

    static {
        RxJavaPlugins.setErrorHandler(new Consumer() {
            @Override
            public void accept(Object o) throws Exception {
                if (o instanceof InterruptedIOException) {
                    Log.d(TAG, "Io interrupted");
                }
            }
        });
    }


    @Override
    public int setLayoutResource() {
        return R.layout.activity_test;
    }

    @Override
    public void initView() {

//       Observable<Integer> observable=Observable.create(new ObservableOnSubscribe<Integer>() {
//           @Override
//           public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                Log.d(TAG,"Observable thread is :"+Thread.currentThread().getName());
//                Log.d(TAG,"emit 1");
//                e.onNext(1);
//           }
//       });
//
//       Consumer<Integer> consumer=new Consumer<Integer>() {
//           @Override
//           public void accept(Integer integer) throws Exception {
//                Log.d(TAG,"Observer thread is :" +Thread.currentThread().getName());
//                Log.d(TAG,"onNext :"+integer);
//           }
//       };
//
//       //多次指定上游的线程只有第一次指定的有效，也就是说多次调用subscribeOn只有第一次有效，其余的会被忽略
//        // 多次指定下游的线程是可以的，也就是说每调用一次observeOn，下游的线程就会切换一次
//
//        //三种线程
//        //Schedulers.newThread() 新线程
//        //Schedulers.io() io线程
//        //Schedulers.computation()代表CPU计算密集型的操作，例如需要大量计算的操作
//        //AndroidSchedulers.mainThread() 安卓主线程
//        observable.subscribeOn(Schedulers.newThread())
//               .subscribeOn(AndroidSchedulers.mainThread())
//               .observeOn(AndroidSchedulers.mainThread())
//               .observeOn(Schedulers.io())
//               .subscribe(consumer);


//        Observable<Integer> observable1 = Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                Log.d(TAG, "emit 1");
//                e.onNext(1);
//                Thread.sleep(1000);
//
//                Log.d(TAG, "emit 2");
//                e.onNext(2);
//                Thread.sleep(1000);
//
//                Log.d(TAG, "emit 3");
//                e.onNext(3);
//                Thread.sleep(1000);
//
//                Log.d(TAG, "emit 4");
//                e.onNext(4);
//                Thread.sleep(1000);
//
//                Log.d(TAG,"emit complete1");
//                e.onComplete();
//            }
//        }).subscribeOn(Schedulers.io());
//
//        Observable<String> observable2=Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(ObservableEmitter<String> e) throws Exception {
//                Log.d(TAG, "emit A");
//                e.onNext("A");
//                Thread.sleep(1000);
//
//                Log.d(TAG, "emit B");
//                e.onNext("B");
//                Thread.sleep(1000);
//
//                Log.d(TAG, "emit C");
//                e.onNext("C");
//                Thread.sleep(1000);
//
//                Log.d(TAG,"emit complete2");
//                e.onComplete();
//            }
//        }).subscribeOn(Schedulers.io());
//
//        Observable.zip(observable1, observable2, new BiFunction<Integer, String, String>() {
//            @Override
//            public String apply(Integer integer, String s) throws Exception {
//                return integer+s;
//            }
//        }).subscribe(new Observer<String>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                Log.d(TAG,"onSubscribe");
//            }
//
//            @Override
//            public void onNext(String value) {
//                Log.d(TAG,"onNext"+value);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.d(TAG,"onError");
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d(TAG,"onComplete");
//            }
//        });

//        Observable<Integer> observable1 = Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
//                for (int i = 0; ; i++) {   //无限循环发事件
//                    emitter.onNext(i);
//                }
//            }
//        }).subscribeOn(Schedulers.io());
//
//        Observable<String> observable2 = Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
//                emitter.onNext("A");
//            }
//        }).subscribeOn(Schedulers.io());
//
//        Observable.zip(observable1, observable2, new BiFunction<Integer, String, String>() {
//            @Override
//            public String apply(Integer integer, String s) throws Exception {
//                return integer + s;
//            }
//        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                Log.d(TAG, s);
//            }
//        }, new Consumer<Throwable>() {
//            @Override
//            public void accept(Throwable throwable) throws Exception {
//                Log.w(TAG, throwable);
//            }
//        });
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                for (int i = 0; ; i++) {
//                    e.onNext(i);
//                }
//            }
//        }).subscribeOn(Schedulers.io())
//                .sample(2, TimeUnit.SECONDS)
//                .subscribe(new Consumer<Integer>() {
//                    @Override
//                    public void accept(Integer integer) throws Exception {
//                        Log.d(TAG, "" + integer);
//                    }
//                });
//        Flowable<Integer> upStream=Flowable.create(new FlowableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(FlowableEmitter<Integer> e) throws Exception {
//                Log.d(TAG,"emit 1");
//                e.onNext(1);
//                Log.d(TAG,"emit 2");
//                e.onNext(2);
//                Log.d(TAG,"emit 3");
//                e.onNext(3);
//                Log.d(TAG,"emit 4");
//                e.onComplete();
//            }
//        }, BackpressureStrategy.ERROR);
//
//        Subscriber<Integer> downStream=new Subscriber<Integer>() {
//            @Override
//            public void onSubscribe(Subscription s) {
//                Log.d(TAG,"onSubscribe");
//                s.request(Long.MAX_VALUE);
//            }
//
//            @Override
//            public void onNext(Integer integer) {
//                Log.d(TAG,"onNext:"+integer);
//            }
//
//            @Override
//            public void onError(Throwable t) {
//                Log.w(TAG,"onError:",t);
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d(TAG,"onComplete");
//            }
//        };
//
//        upStream.subscribe(downStream);
//        final Subscription[] mSubscription = new Subscription[1];
//        Flowable.create(new FlowableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(FlowableEmitter<Integer> e) throws Exception {
//
//            }
//        },BackpressureStrategy.BUFFER).subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<Integer>() {
//                    @Override
//                    public void onSubscribe(Subscription s) {
//                        Log.d(TAG, "onSubscribe");
//                        mSubscription[0] = s;
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "onNext: " + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        Log.w(TAG, "onError: ", t);
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "onComplete");
//                    }
//
//
//                });

        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> e) throws Exception {
                for (int i=0;i<10000;i++){
                    Log.d(TAG,"emit " + i);
                    e.onNext(i);
                }
            }

            //BackpressureStrategy.BUFFER 换一个更大的水缸
            //BackpressureStrategy.LATEST 只保留最新的事件
            //BackpressureStrategy.DROP 直接把存不下的事件丢弃
        },BackpressureStrategy.LATEST).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        Log.d(TAG, "onSubscribe");
                        s.request(128);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.w(TAG, "onError: ", t);
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete");
                    }
                });

    }


    @Override
    public void initVariable() {

    }


    @Override
    public void initData() {

    }
}
