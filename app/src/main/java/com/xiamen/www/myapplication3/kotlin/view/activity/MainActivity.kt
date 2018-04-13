package com.xiamen.www.myapplication3.kotlin.view.activity

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v4.widget.SwipeRefreshLayout
import android.view.View
import android.view.animation.OvershootInterpolator
import android.widget.LinearLayout
import com.mtool.toolslib.core.ioInAndroidOut
import com.xiamen.www.myapplication3.R
import com.xiamen.www.myapplication3.kotlin.module.*
import com.xiamen.www.myapplication3.kotlin.view.fragment.HomeFGM.HomeFragment
import com.xiamen.www.myapplication3.kotlin.view.fragment.LatestInformationFGM.LatestInformationFragment
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.Observables
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.title_main_activity.*
import net.lucode.hackware.magicindicator.FragmentContainerHelper
import net.lucode.hackware.magicindicator.MagicIndicator
import net.lucode.hackware.magicindicator.buildins.UIUtil
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import java.time.Month
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Created by White on 2018/3/14.
 */
class MainActivity : BaseActivity(), View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {

    private var mFragments: MutableList<Fragment> = ArrayList()

    private val mTitles: List<String> = listOf("首页", "电影", "电视剧", "资讯")

    private val mFragmentContainerHelper = FragmentContainerHelper()

    private val mImages: List<Int> = listOf(R.drawable.home_pager_banner, R.drawable.home_pager_popular_recommendation, R.drawable.home_pager_banner, R.drawable.home_pager_popular_recommendation)

    override fun setLayoutResource(): Int = R.layout.activity_main


    override fun initView() {
        //加载四个导航栏(首页，电影，电视剧，资讯)
        initMagicIndicator()
        //加载轮播图
        initBanner()
        //加载电影分类的Fragment
        initFilmClassificationFragments()
        //加载热门推荐的Fragment
        initPopularRecommendation()
        //加载最新资讯的Fragment
        initLatestInformation()
        mFragmentContainerHelper.handlePageSelected(0, false)
        switchPages(0)
    }


    private fun initMagicIndicator() {
        val magicIndicator = findViewById<View>(R.id.magic_indicator4) as MagicIndicator
        val commonNavigator = CommonNavigator(this)
        commonNavigator.adapter = object : CommonNavigatorAdapter() {
            override fun getCount(): Int {
                return mTitles.size
            }

            override fun getTitleView(context: Context, index: Int): IPagerTitleView {
                val simplePagerTitleView = ColorTransitionPagerTitleView(context)
                simplePagerTitleView.normalColor = ContextCompat.getColor(this@MainActivity, R.color.tv_title_text)
                simplePagerTitleView.selectedColor = ContextCompat.getColor(this@MainActivity, R.color.login_btn_checked)
                simplePagerTitleView.text = mTitles[index]
                simplePagerTitleView.setOnClickListener {
                    mFragmentContainerHelper.handlePageSelected(index)
                    switchPages(index)
                }
                return simplePagerTitleView
            }

            override fun getIndicator(context: Context): IPagerIndicator {
                val linePagerIndicator = LinePagerIndicator(context)
                linePagerIndicator.mode = LinePagerIndicator.MODE_EXACTLY
                linePagerIndicator.lineWidth = UIUtil.dip2px(context, 30.0).toFloat()
                linePagerIndicator.lineHeight = UIUtil.dip2px(context, 2.0).toFloat()
                linePagerIndicator.setColors(ContextCompat.getColor(this@MainActivity, R.color.login_btn_checked))
                return linePagerIndicator
            }

            override fun getTitleWeight(context: Context?, index: Int): Float {
                return 1.5f
            }

        }

        magicIndicator.navigator = commonNavigator
        val titleContainer = commonNavigator.titleContainer // must after setNavigator
        titleContainer.showDividers = LinearLayout.SHOW_DIVIDER_MIDDLE
        titleContainer.dividerDrawable = object : ColorDrawable() {
            override fun getIntrinsicWidth(): Int {
                return UIUtil.dip2px(this@MainActivity, 24.0)
            }
        }

        val fragmentContainerHelper = FragmentContainerHelper(magicIndicator)
        fragmentContainerHelper.setInterpolator(OvershootInterpolator(2.0f))
        fragmentContainerHelper.setDuration(300)
        mFragmentContainerHelper.attachMagicIndicator(magicIndicator)
    }


    private fun initBanner() {
        val banner = find<com.youth.banner.Banner>(R.id.banner_activity_main)
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
        //设置图片加载器
        banner.setImageLoader(GlideImageLoader())
        //设置图片集合
        banner.setImages(mImages)
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.Default)
        //设置自动轮播
        banner.isAutoPlay(true)
        //设置轮播时间
        banner.setDelayTime(3500)
        //设置指示器位置
        banner.setIndicatorGravity(BannerConfig.CENTER)

        banner.setOnBannerListener {
        }
        banner.start()
    }


    private fun initFilmClassificationFragments() {
        for (i in mTitles) {
            val homeFragment = HomeFragment()
            val bundle = Bundle()
            bundle.putInt("tag", HomeFragment.FILM_CLASSIFICATION)
            homeFragment.arguments = bundle
            mFragments.add(homeFragment)
        }
    }


    private fun initPopularRecommendation() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val homeFragment = HomeFragment()
        val bundle = Bundle()
        bundle.putInt("tag", HomeFragment.POPULAR_RECOMMENDATION)
        homeFragment.arguments = bundle
        fragmentTransaction.add(R.id.fl_fragment_home_popular_recommendation, homeFragment).show(homeFragment).commit()
    }


    private fun initLatestInformation() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val hotInformationFragment = LatestInformationFragment()
        fragmentTransaction.add(R.id.fl_fragment_home_latest_information, hotInformationFragment).show(hotInformationFragment).commit()
    }


    private fun switchPages(index: Int) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        var fragment: Fragment
        var i = 0
        val j = mFragments.size
        while (i < j) {
            if (i == index) {
                i++
                continue
            }
            fragment = mFragments[i]
            if (fragment.isAdded) {
                fragmentTransaction.hide(fragment)
            }
            i++
        }

        fragment = mFragments[index]
        if (fragment.isAdded) {
            fragmentTransaction.show(fragment)
        } else {
            fragmentTransaction.add(R.id.fl_fragment_home_film_classification, fragment)
        }
        fragmentTransaction.commitAllowingStateLoss()
    }


    override fun initVariable() {
        srl_fragment_home.setOnRefreshListener(this)
    }


    override fun initData() {
        tv_activity_main_sign.setOnClickListener(this)
        iv_activity_sz.setOnClickListener(this)
        iv_activity_yh.setOnClickListener(this)
    }


    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.tv_activity_main_sign -> {
                startActivity<SignCenterActivity>()
            }
            R.id.iv_activity_sz -> {
                startActivity<SettingsActivity>()
            }
            R.id.iv_activity_yh -> {
                startActivity<PersonCenterActivity>()
            }
        }
    }


    override fun onRefresh() {
        Observable.timer(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    srl_fragment_home.isRefreshing = false
                }
    }

}