package com.xiamen.www.myapplication3.kotlin.view.fragment.HomeFGM

import android.opengl.Visibility
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.RenderProcessGoneDetail
import android.widget.GridLayout
import android.widget.Space
import com.mtool.toolslib.base.core.ext.setDrawableLeft
import com.mtool.toolslib.network.activity.fragment.BaseStylesFragment
import com.xiamen.www.myapplication3.R
import com.xiamen.www.myapplication3.kotlin.module.bean.FilmClassificationBean
import com.xiamen.www.myapplication3.kotlin.view.adapter.FilmClassificationAdapter
import kotlinx.android.synthetic.main.fragment_film.*
import kotlinx.android.synthetic.main.item_home_page_item.*
import org.jetbrains.anko.support.v4.find

/**
 * Created by White on 2018/3/14.
 */
class HomeFragment : BaseStylesFragment() {

    companion object {
        val FILM_CLASSIFICATION = 1
        val POPULAR_RECOMMENDATION = 2
    }

    private lateinit var filmData: MutableList<FilmClassificationBean>

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_film, container, false)
    }

    override fun initDate() {
        when (arguments.getInt("tag")) {
            FILM_CLASSIFICATION -> {
                setItemTitle("电影分类", View.VISIBLE, R.drawable.activity_main_fl)
                rb_european_and_american_films.isChecked=true
                val data1 = FilmClassificationBean(R.drawable.home_pager_film_classification, "变形金刚", "变形金刚变形金刚变形金刚变形金刚变形金刚")
                filmData = mutableListOf(data1, data1, data1, data1)
            }
            POPULAR_RECOMMENDATION -> {
                setItemTitle("热门推荐", View.GONE, R.drawable.activity_main_rm)
                val data1 = FilmClassificationBean(R.drawable.home_pager_popular_recommendation, "前任3", "前任三刚出来不久，人气就大涨哈哈哈")
                filmData = mutableListOf(data1, data1, data1, data1)
            }
        }
        initRecyclerView()
    }


    private fun setItemTitle(title: String, tag: Int, drawableLeft: Int) {
        rg_item_select.visibility = tag
        tv_item_title.text = title
        tv_item_title.setDrawableLeft(drawableLeft)
    }


    private fun initRecyclerView() {
        val recyclerView = find<RecyclerView>(R.id.recycler_view_fragment_film_list)
        val gridLayout = GridLayoutManager(activity, 2)
        val adapter = FilmClassificationAdapter(activity, filmData)
        gridLayout.isSmoothScrollbarEnabled=true
        gridLayout.isAutoMeasureEnabled=true
        recyclerView.setHasFixedSize(true)
        recyclerView.isNestedScrollingEnabled=false
        recyclerView.layoutManager = gridLayout
        recyclerView.adapter = adapter
    }

}