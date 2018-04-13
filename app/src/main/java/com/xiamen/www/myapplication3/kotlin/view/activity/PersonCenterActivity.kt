package com.xiamen.www.myapplication3.kotlin.view.activity

import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.mtool.toolslib.view.custom.glide.BlurTransformation
import com.xiamen.www.myapplication3.R
import com.xiamen.www.myapplication3.kotlin.module.bean.HistoricalRecordsBean
import com.xiamen.www.myapplication3.kotlin.view.adapter.MyHistoricalRecordsAdapter
import kotlinx.android.synthetic.main.activity_person_center_new.*
import kotlinx.android.synthetic.main.title_return_top.*
import org.jetbrains.anko.startActivity
import javax.microedition.khronos.opengles.GL

/**
 * Created by White on 2018/3/9.
 */
class PersonCenterActivity : BaseActivity(), View.OnClickListener {


    private lateinit var historicalRecordData: List<HistoricalRecordsBean>

    override fun setLayoutResource(): Int = R.layout.activity_person_center_new

    override fun initView() {
        tv_title.text = "用户中心"
        iv_right.setImageDrawable(resources.getDrawable(R.drawable.person_center_sz))
        tv_person_center_play_history.setOnClickListener(this)
//        setSupportActionBar(toolbar)
//        toolbar.setNavigationIcon(R.drawable.ic_action_back)
////        toolbar.title = "个人中心"
////        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        toolbar.setNavigationOnClickListener {
//            onBackPressed()
//        }
//        Glide.with(this).load(R.drawable.person_center_bg).apply(RequestOptions().transform(BlurTransformation(this, 1))).into(object : SimpleTarget<Drawable>() {
//            override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>) {
//                collapsing_toolbar_layout.setContentScrim(resource)
//            }
//        })
//        collapsing_toolbar_layout.setContentScrim(ContextCompat.getDrawable(this,R.drawable.person_center_bg))
    }


    override fun initVariable() {
        app_bar_layout.addOnOffsetChangedListener { appBarLayout, verticalOffset ->
            if (verticalOffset <= head_layout.height / 2) {
//                toolbar.title = "个人中心"
//                collapsing_toolbar_layout.title="个人中心"
            } else {
//                toolbar.title = "个人中心"
//                collapsing_toolbar_layout.title=""
            }
        }
    }


    override fun initData() {
        val data1 = HistoricalRecordsBean(R.drawable.person_center_watch_record, "我的前半生18", "54%")
        val data2 = HistoricalRecordsBean(R.drawable.person_center_watch_record, "我的前半生19", "52%")
        val data3 = HistoricalRecordsBean(R.drawable.person_center_watch_record, "我的前半生20", "已看完")
        val data4 = HistoricalRecordsBean(R.drawable.person_center_watch_record, "我的前半生21", "20%")
        historicalRecordData = listOf(data1, data2, data3, data4)
        initRecyclerView()
        initOnclickListener()

    }


    private fun initOnclickListener() {
        tv_person_center_play_history.setOnClickListener(this)
        tv_person_center_collection_record.setOnClickListener(this)
        tv_person_center_offline_caching.setOnClickListener(this)
        tv_person_center_video_upload.setOnClickListener(this)
        tv_person_center_integral_center.setOnClickListener(this)
        tv_person_center_cash_center.setOnClickListener(this)
        tv_person_center_charge_center.setOnClickListener(this)
        tv_person_center_subscribed_channels.setOnClickListener(this)
        tv_person_center_complaint_proposal.setOnClickListener(this)
        tv_person_center_sign.setOnClickListener(this)
        iv_person_center_head_portrait.setOnClickListener(this)
        tv_person_center_integral.setOnClickListener(this)
        iv_right.setOnClickListener(this)
        iv_back.setOnClickListener(this)
    }


    /**
     * 初始化recyclerView布局
     */
    private fun initRecyclerView() {
        val linearLayout = LinearLayoutManager(this)
        //设置横向布局管理器
        linearLayout.orientation = LinearLayoutManager.HORIZONTAL
        rcv_record.layoutManager = linearLayout
        //设置适配器
        val adapter = MyHistoricalRecordsAdapter(this, historicalRecordData)
        rcv_record.adapter = adapter
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_right -> {
                startActivity<SettingsActivity>()
            }
            R.id.iv_back -> {
                finish()
            }
            R.id.tv_person_center_play_history -> {
            }
            R.id.tv_person_center_collection_record -> {
            }
            R.id.tv_person_center_offline_caching -> {
            }
            R.id.tv_person_center_video_upload -> {
            }
            R.id.tv_person_center_integral_center -> {
            }
            R.id.tv_person_center_cash_center -> {
            }
            R.id.tv_person_center_charge_center -> {
            }
            R.id.tv_person_center_subscribed_channels -> {
            }
            R.id.tv_person_center_complaint_proposal -> {
            }
            R.id.tv_person_center_sign -> {
            }
            R.id.iv_person_center_head_portrait -> {
            }
            R.id.tv_person_center_integral -> {
            }


        }
    }

}