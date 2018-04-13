package com.xiamen.www.myapplication3.kotlin.view.activity

import android.support.v4.content.ContextCompat
import android.text.SpannableString
import android.view.ViewGroup
import android.view.View
import com.xiamen.www.myapplication3.R
import kotlinx.android.synthetic.main.title_return_top.*
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.textColor

/**
 * Created by White on 2018/3/16.
 */
class SettingsActivity : BaseActivity(){
    override fun setLayoutResource(): Int = R.layout.activity_settings

    override fun initView() {
        iv_back.setImageResource(R.drawable.settings_back)
        tv_title.text="设置"
        tv_title.textColor=ContextCompat.getColor(this,R.color.wjf_font_light)
        iv_right.visibility = View.GONE

    }


    override fun initVariable() {
    }


    override fun initData() {
    }

}