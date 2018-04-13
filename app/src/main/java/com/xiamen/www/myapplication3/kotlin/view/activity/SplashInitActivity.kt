package com.xiamen.www.myapplication3.kotlin.view.activity

import com.xiamen.www.myapplication3.R
import com.xiamen.www.myapplication3.kotlin.utils.InternetUtils

/**
 * Created by White on 2018/3/7.
 */
class SplashInitActivity :BaseActivity(){
    override fun setLayoutResource(): Int =R.layout.activity_splash_init

    override fun initView() {
        val internetError=InternetUtils.isNetworkAvalible(this)
        if (internetError){

        }else{

        }

    }


    override fun initVariable() {
    }


    override fun initData() {
    }

}
