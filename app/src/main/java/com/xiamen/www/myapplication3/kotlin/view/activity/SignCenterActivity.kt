package com.xiamen.www.myapplication3.kotlin.view.activity


import android.support.v4.content.ContextCompat
import android.text.Spannable
import android.text.SpannableString
import android.text.style.RelativeSizeSpan
import android.view.View
import android.widget.TextView
import com.xiamen.www.myapplication3.R
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_sign_center.*
import kotlinx.android.synthetic.main.title_return_top.*
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.textColor

/**
 * Created by White on 2018/3/16.
 */
class SignCenterActivity:BaseActivity(){
    override fun setLayoutResource(): Int = R.layout.activity_sign_center

    override fun initView() {
        iv_back.imageResource=R.drawable.settings_back
        tv_title.text="签到中心"
        tv_title.textColor= ContextCompat.getColor(this,R.color.wjf_font_light)
        iv_right.visibility=View.GONE

        val spannableString = SpannableString("2天")
        //设置字体大小为原来的两倍
        val sizeSpan= RelativeSizeSpan(2.0f)
        spannableString.setSpan(sizeSpan,0,1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
        tv_sign_center_days.text=spannableString



    }


    override fun initVariable() {
    }


    override fun initData() {
    }

}

