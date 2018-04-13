package com.xiamen.www.myapplication3.kotlin.view.activity

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.view.Window
import org.jetbrains.anko.doFromSdk

/**
 * Created by White on 2018/3/7.
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        try {
            super.onCreate(savedInstanceState)
            doFromSdk(21) {
                //android版本21以上允许使用transitions
                window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
            }
            setContentView(setLayoutResource())
            //设置屏幕方向为竖向
            setDefaultOrientation()
            initView()
            initVariable()
            initData()
        } catch (e: Exception) {
            e.printStackTrace()
            finish()
        }

    }

    abstract fun setLayoutResource(): Int

    abstract fun initView()

    abstract fun initVariable()

    abstract fun initData()

    open fun setDefaultOrientation() {
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
        beginTransaction().func().commit()
    }

    /**
     * 在activity中操作fragment
     */
    fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int) {
        supportFragmentManager.inTransaction { add(frameId, fragment) }
    }

    fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int) {
        supportFragmentManager.inTransaction { replace(frameId, fragment) }
    }

    fun AppCompatActivity.showFragment(fragment: Fragment) {
        supportFragmentManager.inTransaction { show(fragment) }
    }

    fun AppCompatActivity.hideFragment(fragment: Fragment) {
        supportFragmentManager.inTransaction { hide(fragment) }
    }



}