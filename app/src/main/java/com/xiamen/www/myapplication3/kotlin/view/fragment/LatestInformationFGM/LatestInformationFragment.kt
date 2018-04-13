package com.xiamen.www.myapplication3.kotlin.view.fragment.LatestInformationFGM

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.mtool.toolslib.base.core.ext.setDrawableLeft
import com.xiamen.www.myapplication3.R
import com.xiamen.www.myapplication3.kotlin.module.bean.FilmClassificationBean
import com.xiamen.www.myapplication3.kotlin.view.adapter.HotInformationAdapter
import com.xiamen.www.myapplication3.kotlin.view.fragment.BaseFGM.BaseFragment
import kotlinx.android.synthetic.main.item_home_page_item.*
import org.jetbrains.anko.support.v4.find

/**
 * Created by White on 2018/3/14.
 */
class LatestInformationFragment : BaseFragment() {

    private lateinit var filmData: MutableList<FilmClassificationBean>

    override fun setLayoutResourceID(): Int = R.layout.fragment_hot_information

    override fun initView() {
        tv_item_title.text = "最新资讯"
        tv_item_title.setDrawableLeft(R.drawable.activity_main_zx)
    }

    override fun initData() {
        val data1=FilmClassificationBean(R.drawable.home_pager_latest_information_big,"范斌并出席","范斌并出席范斌并出席范斌并出席")
        val data2=FilmClassificationBean(R.drawable.home_pager_latest_information,"逝去的《芳华》","逝去的《芳华》摄影红色...")
        val data3=FilmClassificationBean(R.drawable.home_pager_latest_information,"逝去的《芳华》","逝去的《芳华》摄影红色...")
        filmData= mutableListOf(data1,data2,data3)
//        filmData= mutableListOf(data1)
        initRecyclerView()
    }


    fun initRecyclerView(){
        val recyclerView = find<RecyclerView>(R.id.recycler_view_hot_information_list)
        val layoutManager=LinearLayoutManager(activity)
        val adapter= HotInformationAdapter(activity,filmData)
        layoutManager.isSmoothScrollbarEnabled=true
        layoutManager.isAutoMeasureEnabled=true
        recyclerView.setHasFixedSize(true)
        recyclerView.isNestedScrollingEnabled=false
        recyclerView.layoutManager=layoutManager
        recyclerView.adapter=adapter
    }
}