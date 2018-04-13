package com.xiamen.www.myapplication3.kotlin.rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.xiamen.www.myapplication3.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


public class Main5Activity extends AppCompatActivity {


    private static final String TAG = "Main5Activity";
    private EditText et;
    private TextView tv;
    private EditText et2;
    private EditText et3;
    private Button btn_commit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
//        et = (EditText) findViewById(R.id.et_test_editText);
//        tv= (TextView) findViewById(R.id.tv_textView);
//        et2= (EditText) findViewById(R.id.et_test_2);
//        et3= (EditText) findViewById(R.id.et_test_3);
//        btn_commit=(Button)findViewById(R.id.btn_commit);
//        /**
//         * 1.此处采用改了RXBinding：RxTextView.textChanges(name) = 对控件数据变更进行监听(功能类似TextWatcher)
//         * 2.传入EditText控件，输入字符时都会发送数据事件(此处不会马上发送，因为使用了debounce())
//         * 3.采用skip(1)原因：跳过第一次请求初始输入框的空字符状态
//         */
//        RxTextView.textChanges(et)
//                .debounce(1, TimeUnit.SECONDS)
//                .skip(1)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<CharSequence>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(CharSequence value) {
//                        tv.setText(value.toString());
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//
//    io.reactivex.Observable<CharSequence> firstObservable=RxTextView.textChanges(et).skip(1);
//    io.reactivex.Observable<CharSequence> secondObservable=RxTextView.textChanges(et2).skip(1);
//        io.reactivex.Observable<CharSequence> thirdObservable = RxTextView.textChanges(et3).skip(1);
//
//        /**
//         * 通过combineLatest()合并事件&联合判断
//         */
//        Observable.combineLatest(firstObservable, secondObservable, thirdObservable, new Function3<CharSequence, CharSequence, CharSequence, Boolean>() {
//            @Override
//            public Boolean apply(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) throws Exception {
//                /**
//                 * 步骤4:规定表单信息输入不能为空
//                 */
//                //1.姓名信息
//                boolean isUserNameValid=!TextUtils.isEmpty(et.getText().toString());
//                //2.年龄信息
//                boolean isUserAgeValid=!TextUtils.isEmpty(et2.getText().toString());
//                //3.职业信息
//                boolean isUserJobValid=!TextUtils.isEmpty(et3.getText().toString());
//                return isUserNameValid&&isUserAgeValid&&isUserJobValid;
//            }
//        }).subscribe(new Consumer<Boolean>() {
//            @Override
//            public void accept(Boolean aBoolean) throws Exception {
//                btn_commit.setEnabled(aBoolean);
//            }
//        });

//        创建一个上游Observable
//        io.reactivex.Observable<Integer> observabl= io.reactivex.Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                e.onNext(1);
//                e.onNext(1);
//                e.onNext(1);
//                e.onNext(1);
//                e.onComplete();//这里必须调用该方法或者onError(),通知订阅者发送完毕，否则无法接触订阅
//            }
//        });
//
//        //创建一个下游Observer
//        Observer<Integer> observer=new Observer<Integer>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                Log.d(TAG,"subscribe");
//            }
//
//            @Override
//            public void onNext(Integer integer) {
//                Log.d(TAG,""+integer);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.d(TAG,"error");
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d(TAG,"complete");
//            }
//        };
//
//        observabl.subscribe(observer);

//
//        io.reactivex.Observable.interval(2,TimeUnit.SECONDS)
//                .subscribe(new Observer<Long>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Long aLong) {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });

//        io.reactivex.Observable.just(6)
//                .map(new Function<Integer, String>() {
//                    @Override
//                    public String apply(Integer integer) throws Exception {
//                        return integer+"3";
//                    }
//                }).subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                Log.d("a","aa");
//            }
//        });

//
///**
// * 练习时间
// *
// *练习 1  统计集合中年龄大于20的学生姓名（年龄姓名一致的视为同一个）
// *
// */
        List<Student> students;
        //初始化数据
        Student s1 = new Student(19, "xiaoqiang0");
        Student s2 = new Student(20, "xiaoqiang1");
        Student s3 = new Student(21, "xiaoqiang2");
        Student s4 = new Student(22, "xiaoqiang3");
        Student s5 = new Student(23, "xiaoqiang4");
        Student s6 = new Student(24, "xiaoqiang5");
        Student s7 = new Student(25, "xiaoqiang6");
        Student s8 = new Student(25, "xiaoqiang7");
        students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s1);
        students.add(s4);
        students.add(s5);
        students.add(s6);
        students.add(s7);
        students.add(s8);
//
//        io.reactivex.Observable.just(students)
//                .flatMap(new Function<List<Student>, ObservableSource<Student>>() {
//                    @Override
//                    public ObservableSource<Student> apply(List<Student> students) throws Exception {
//                        return io.reactivex.Observable.fromIterable(students);
//                    }
//                }).distinct()
//                .filter(new Predicate<Student>() {
//                    @Override
//                    public boolean test(Student student) throws Exception {
//                        return student.getI() >= 20;
//                    }
//                })
//                .map(new Function<Student, String>() {
//                    @Override
//                    public String apply(Student student) throws Exception {
//                        return student.getXiaoqiang0();
//                    }
//                }).subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                Log.e(TAG, s);
//            }
//        });
//        //过滤掉年龄小于20的对象


//        //时间间隔输出字符串
//        final List<String> list= Arrays.asList("one","two","three","four","five");
//        //每隔两秒输出一个字符串
//        io.reactivex.Observable.interval(2000,2000,TimeUnit.MICROSECONDS)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<Long>() {
//                    @Override
//                    public void accept(Long aLong) throws Exception {
//                        int i=aLong.intValue();
//                        if (i==list.size()){
//                            return;
//                        }
//                    }
//                });
//


//---------------------------------------------------------------------------------------------------------------------------------------
//        http://blog.csdn.net/zhaoyanjun6/article/details/76443347
        /**
         * Map修饰符
         */

        io.reactivex.Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
            }
        }).map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) throws Exception {
                return integer + "变化了";
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
//                        Log.e(TAG, s);
                    }
                });



        /**
         * flatMap修饰符 无序的
         */
        io.reactivex.Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
            }
        }).flatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Integer integer) throws Exception {
                List<String> list = new ArrayList<>();
                list.add("I am value" + integer);
                //随机生成一个时间
                int delayTime = (int) (1 + Math.random() * 10);
                return io.reactivex.Observable.fromIterable(list).delay(delayTime, TimeUnit.MILLISECONDS);
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
//                Log.e(TAG, "accept:" + s);
            }
        });

        /**
         * concatMap操作符
         */
        io.reactivex.Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
            }
        }).concatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Integer integer) throws Exception {
                List<String> list = new ArrayList<>();
                list.add("I am value" + integer);
                //随机生成一个时间
                int delayTime = (int) (1 + Math.random() * 10);
                return io.reactivex.Observable.fromIterable(list).delay(delayTime, TimeUnit.MILLISECONDS);
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
//                    Log.e(TAG,s+" concatMap操作符");
            }
        });

        /**
         * zip操作符
         */
        io.reactivex.Observable<Integer> observable=io.reactivex.Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(1);
                e.onNext(1);
                e.onNext(1);
            }
        });


        io.reactivex.Observable<Integer> observable1=io.reactivex.Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(3);
                e.onNext(4);
                e.onNext(5);
            }
        });
        
        io.reactivex.Observable.zip(observable1, observable, new BiFunction<Integer, Integer, String>() {
            @Override
            public String apply(Integer integer, Integer integer2) throws Exception {
                return integer+integer2+"";
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
//                Log.e(TAG,"组合之后是:"+s);
            }
        });


        /**
         * interval操作符
         */
        //方法1
        Flowable.interval(1, TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
//                        Log.e(TAG,aLong+"");
                    }
                });

//方法2
        io.reactivex.Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
//                        Log.e("zhao", "accept:22> " + aLong);
                    }
                });

        /**
         * 实现倒计时功能
         */
        countDown(4).subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
//                Log.e(TAG,"倒计时开始："+aLong);
            }
        });


        /**
         * repeat操作符:重复的发射数据
         */

        io.reactivex.Observable.just(1,2)
                .repeat(3)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
//                        Log.e(TAG,integer+"");
                    }
                });

        /**
         * 发射特定的整数序列
         */
        io.reactivex.Observable.range(1,5)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
//                        Log.e(TAG,""+integer);
                    }
                });

        /**
         * 遍历数组
         */
        Integer[] items={0,1,2,3,4,5};
        io.reactivex.Observable.fromArray(items)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
//                        Log.e(TAG,""+integer);
                    }
                });

        /**
         * 遍历集合
         */
        List<String> list=new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        io.reactivex.Observable.fromIterable(list)
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
//                        Log.e(TAG,s);
                    }
                });


        /**
         * toList:把数据转换成List集合
         */
        io.reactivex.Observable.range(1,4)
                .toList()
                .subscribe(new Consumer<List<Integer>>() {
                    @Override
                    public void accept(List<Integer> integers) throws Exception {
//                        log(integers+"");
                    }
                });


        /**
         * 把数组转化成List集合
         */
        Integer[] items2={0,1,2,3,4,5,6};

        io.reactivex.Observable.fromArray(items2)
                .toList()
                .subscribe(new Consumer<List<Integer>>() {
                    @Override
                    public void accept(List<Integer> integers) throws Exception {
//                        log(""+integers);
                    }
                });

        /**
         * delay 延迟发射数据
         */
        io.reactivex.Observable.just(1,2,3)
                .delay(3,TimeUnit.SECONDS)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
//                        log(integer.toString());
                    }
                });


        /**
         * 背压
         */
        io.reactivex.Observable.interval(1,TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Thread.sleep(1);
                        log(aLong.toString());
                    }
                });

    }


    public void log(String str){
        Log.e(TAG,str);
    }

    /**
     * 创建一个倒计时的Observable
     */
    public io.reactivex.Observable<Long> countDown(final long time){

        return io.reactivex.Observable.interval(1,TimeUnit.SECONDS)
                .map(new Function<Long, Long>() {
                    @Override
                    public Long apply(Long aLong) throws Exception {
                        return time-aLong;
                    }
                }).take(time + 1 );
        //take 过滤，只发送前5个字符
    }





//    public<T> io.reactivex.Observable<T> countDown(T t){
//        return io.reactivex.Observable.interval((long)t,TimeUnit.SECONDS)
//                .map(new Function<Long, T>() {
//                    @Override
//                    public T apply(Long aLong) throws Exception {
//                        return null;
//                    }
//                }).take((long)t + 1);
//    }



    /**
     * String 看定影
     *
     * @param view
     */
    public void send(View view) {


//
//        //1.链式调度
//        Observable.create(new OnSubscrible<String>() {
//            @Override
//            public void call(Subscrible<? super String> subscrible) {
//                subscrible.onNext("男生，走去看电影去");
//            }
//        }).subSrible(new Subscrible<String>() {
//            @Override
//            public void onNext(String s) {
//                System.out.println(s);
//                System.out.println("好的，可以一起去看电影");
//            }
//        });



    }

    private class Student {

        private int i;
        private String xiaoqiang0;

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        public String getXiaoqiang0() {
            return xiaoqiang0;
        }

        public void setXiaoqiang0(String xiaoqiang0) {
            this.xiaoqiang0 = xiaoqiang0;
        }

        public Student() {
        }

        public Student(int i, String xiaoqiang0) {
            this.i = i;
            this.xiaoqiang0 = xiaoqiang0;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Student student = (Student) o;

            return i == student.i && (xiaoqiang0 != null ? xiaoqiang0.equals(student.xiaoqiang0) : student.xiaoqiang0 == null);
        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + (xiaoqiang0 != null ? xiaoqiang0.hashCode() : 0);
            return result;
        }
    }
}
