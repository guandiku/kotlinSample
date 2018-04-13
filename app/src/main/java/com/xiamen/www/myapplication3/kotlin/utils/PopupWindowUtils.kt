package com.xiamen.www.myapplication3.kotlin.utils

import android.content.Context
import android.graphics.drawable.BitmapDrawable
import android.support.annotation.Nullable
import android.view.LayoutInflater
import android.view.View
import android.widget.PopupWindow
import com.xiamen.www.myapplication3.R
import org.jetbrains.anko.wrapContent

/**
 * Created by White on 2018/4/1.
 */
class PopupWindowUtils(val layout:Int = R.layout.layout_popupwindow,val context:Context,val goalView:View) {

    val view=LayoutInflater.from(context).inflate(layout,null)
    val pop=PopupWindow(view, wrapContent, wrapContent,false)

        //出现在左边
        fun showPopWindowLeft(){
            pop.isFocusable=true
            pop.setBackgroundDrawable(BitmapDrawable())
            pop.isOutsideTouchable=true
            view.measure(View.MeasureSpec.UNSPECIFIED,View.MeasureSpec.UNSPECIFIED)
            val mShowMorePopupWindowWidth=-view.measuredWidth
            val mShowMorePopupWindowHeight=-view.measuredHeight
            pop.showAsDropDown(goalView,mShowMorePopupWindowWidth,mShowMorePopupWindowHeight)

        }

        //出现在右边
        fun showPopWindowRight(){

            pop.isFocusable=true
            pop.setBackgroundDrawable(BitmapDrawable())
            pop.isOutsideTouchable=true
            view.measure(View.MeasureSpec.UNSPECIFIED,View.MeasureSpec.UNSPECIFIED)
            val mShowMorePopupWindowHeight=view.measuredHeight
            val goalViewWidth =goalView.measuredWidth
            //以指定view的左下角为原点,以x轴正方向便宜100个像素，以y轴正方向偏移xx个像素
            pop.showAsDropDown(goalView,goalViewWidth,-mShowMorePopupWindowHeight)

        }

        //出现在上边
        fun showPopWindowUp(){
            pop.isFocusable=true
            pop.setBackgroundDrawable(BitmapDrawable())
            pop.isOutsideTouchable=true
            view.measure(View.MeasureSpec.UNSPECIFIED,View.MeasureSpec.UNSPECIFIED)
            val mShowMorePopupWindowHeight=-view.measuredHeight
            pop.showAsDropDown(goalView,0,mShowMorePopupWindowHeight-goalView.measuredHeight)
        }


        //出现在下边
        fun showPopWindowDown(){
            pop.isFocusable=true
            pop.setBackgroundDrawable(BitmapDrawable())
            pop.isOutsideTouchable=true
            pop.showAsDropDown(goalView)

        }




}