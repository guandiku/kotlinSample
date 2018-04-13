package com.xiamen.www.myapplication3.kotlin.view.fragment.HomeFGM

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.xiamen.www.myapplication3.kotlin.module.bean.FilmClassificationBean
import io.reactivex.subjects.BehaviorSubject

/**
 * Created by White on 2018/3/14.
 */
class HomeVM: ViewModel(){


    var isLogin:BehaviorSubject<Boolean> = BehaviorSubject.createDefault(false)
    var inTryMode:BehaviorSubject<Boolean> = BehaviorSubject.createDefault(false)

    var listData:BehaviorSubject<List<FilmClassificationBean>> = BehaviorSubject.create()
//    companion object {
//        var
//    }
}