package com.xiamen.www.myapplication3.kotlin.module

import android.content.Context
import android.widget.ImageView
import com.mtool.toolslib.annotation.GlideRequest
import com.mtool.toolslib.annotation.GlideRequests
import com.mtool.toolslib.base.core.ext.isNotNull
import com.mtool.toolslib.view.custom.glide.SimpleImageTarget
import com.youth.banner.loader.ImageLoader

/**
 * Created by White on 2018/3/15.
 */
class HomeBannerLoader(var glideManager: GlideRequests) : ImageLoader() {
    override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
        try {
            imageView.isNotNull {
                val mile = System.currentTimeMillis()
                glideManager.load(path.toString())
                        .into(SimpleImageTarget(it))
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    override fun createImageView(context: Context?): ImageView {
        val iv = ImageView(context)
        iv.scaleType = ImageView.ScaleType.CENTER
        return super.createImageView(context)
    }

}