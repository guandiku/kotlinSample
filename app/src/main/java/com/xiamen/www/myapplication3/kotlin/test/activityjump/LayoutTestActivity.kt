package com.xiamen.www.myapplication3.kotlin.test.activityjump

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.ViewGroup
import android.view.View
import com.xiamen.www.myapplication3.R
import android.widget.TextView



class LayoutTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_test)

        initView()
    }

    private fun initView() {

        //如果include布局根容器和include标签中的id设置的是不同的值，这里获取的mToolbar值将为null
        val mToolbar = findViewById<View>(R.id.tb_toolbar) as Toolbar
        setSupportActionBar(mToolbar)

        //普通include标签用法,直接拿子View属性实现
        val textView = findViewById<View>(R.id.textView) as TextView
        textView.text = "不加ID实现的include标签"

        //多个include标签用法,添加ID,findViewByID找到layout,再找子控件
        val view_include = findViewById<View>(R.id.include_text1)
        val view_include_textView = view_include.findViewById(R.id.textView) as TextView
        view_include_textView.text = "加了ID实现的include标签"

        //多个include标签用法,添加ID,findViewByID找到layout,再找子控件
        val view_include_Relative = findViewById<View>(R.id.include_text2)
        val view_textView_relative = view_include_Relative.findViewById(R.id.textView) as TextView
        view_textView_relative.text = "加了ID实现的include标签(RelaviteLayout)"

    }
}
