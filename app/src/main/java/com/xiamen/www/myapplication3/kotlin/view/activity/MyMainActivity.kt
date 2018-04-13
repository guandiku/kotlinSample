package com.xiamen.www.myapplication3.kotlin.view.activity

import android.view.View
import com.xiamen.www.myapplication3.R
import com.xiamen.www.myapplication3.kotlin.utils.PopupWindowUtils
import kotlinx.android.synthetic.main.activity_my_main.*

/**
 * Created by White on 2018/4/1.
 */
class MyMainActivity : BaseActivity() {


    override fun setLayoutResource(): Int = R.layout.activity_my_main

    override fun initView() {
        tv_left.setOnClickListener {
            //具名参数和不具名参数
            val popupWindowUtils = PopupWindowUtils(context = this, goalView = it)
            popupWindowUtils.showPopWindowLeft()
        }

        tv_right.setOnClickListener {
            val popupWindowUtils = PopupWindowUtils(context = this, goalView = it)
            popupWindowUtils.showPopWindowRight()
        }

        tv_up.setOnClickListener {
            val popupWindowUtils = PopupWindowUtils(context = this, goalView = it)
            popupWindowUtils.showPopWindowUp()
        }

        tv_down.setOnClickListener {
            val popupWindowUtils = PopupWindowUtils(context = this, goalView = it)
            popupWindowUtils.showPopWindowDown()
        }
    }

    override fun initVariable() {
    }

    override fun initData() {
    }

}