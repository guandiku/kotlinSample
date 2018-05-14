package com.xiamen.www.myapplication3.kotlin.myview.scrollmyselfview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Scroller
import com.xiamen.www.myapplication3.R
import kotlinx.android.synthetic.main.activity_scrolling2.*

class ScrollingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling2)

    }


    private fun smoothScrollTo(destX:Int,destY:Int){

    }
}
