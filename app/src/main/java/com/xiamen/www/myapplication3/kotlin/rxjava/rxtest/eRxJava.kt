package com.xiamen.www.myapplication3.kotlin.rxjava.rxtest

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * Created by White on 2018/3/12.
 */
fun <T> Observable<T>.ioInAndroidOut(): Observable<T> {
    return subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}

fun <T> Observable<T>.computInAndroidOut(): Observable<T> {
    return subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread())
}

fun <T> Observable<T>.androidInAndroidOut(): Observable<T> {
    return subscribeOn(AndroidSchedulers.mainThread())
            .observeOn(AndroidSchedulers.mainThread())
}

fun <T> Observable<T>.debounceForEditText(): Observable<T> {
    return debounce(500, TimeUnit.MILLISECONDS)
}


fun <T> Observable<T>.debounceForButton(): Observable<T> {
    return debounce(1, TimeUnit.SECONDS)
}

fun <T> Observable<T>.debounceForIO(): Observable<T> {
    return debounce(100, TimeUnit.MILLISECONDS)
}

