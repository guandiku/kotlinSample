package com.xiamen.www.myapplication3.kotlin.test.activityjump

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.xiamen.www.myapplication3.R
import com.xiamen.www.myapplication3.kotlin.view.activity.BaseActivity
import kotlinx.android.synthetic.main.activity_main10.*
import org.jetbrains.anko.startActivity

class Main10Activity : BaseActivity() {
    override fun setLayoutResource(): Int {
        return R.layout.activity_main10
    }

    override fun initView() {
        btn_return.setOnClickListener {
            startActivity<Main11Activity>()
        }
    }

    override fun initVariable() {
    }

    override fun initData() {
    }


}
