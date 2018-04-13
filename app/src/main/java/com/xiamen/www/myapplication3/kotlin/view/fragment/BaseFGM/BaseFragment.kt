package com.xiamen.www.myapplication3.kotlin.view.fragment.BaseFGM

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by White on 2018/3/8.
 */
abstract class BaseFragment : Fragment() {

    val name: String get() = javaClass.simpleName

    private lateinit var mContentView: View
    private lateinit var mContext: Context
    val disposable = CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("NewApi")
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        try {
            mContentView = inflater?.inflate(setLayoutResourceID(), container, false)!!
            mContext = context
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            return mContentView
        }
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        initView()
        initData()
        super.onActivityCreated(savedInstanceState)
    }

    /**
     * 返回该布局的ID
     */
    abstract fun setLayoutResourceID(): Int

    abstract fun initView()

    abstract fun initData()


    fun getContentView(): View {
        return mContentView
    }

    fun getMContext(): Context {
        return mContext
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.clear()
    }


}