package com.xiamen.www.myapplication3.kotlin.utils

import android.app.Application
import android.content.Context
import android.media.AudioManager
import android.net.ConnectivityManager
import android.telephony.TelephonyManager
import android.util.Pair
import kotlin.properties.Delegates

/**
 * Created by White on 2018/3/7.
 */
class AppBase : Application() {


    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        registerActivityLifecycleCallbacks(ActivityManager.callback)
    }

    /**
     * 调用时刻：应用程序结束时调用
     */
    override fun onTerminate() {
        super.onTerminate()
        ActivityManager.finishAllActivity()
        ActivityManager.onTerminate()
    }


    companion object {
        var context: Context by Delegates.notNull()

        fun connectivityManager() = ActivityManager.topContext().getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager

        fun audioManager() = ActivityManager.topContext().getSystemService(Context.AUDIO_SERVICE) as AudioManager
        //        fun wifiManager() = ActivityManager.topContext().getSystemService(Context.WIFI_SERVICE) as WifiManager
        fun telephonyManager() = ActivityManager.topContext().getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

        fun packageManager() = ActivityManager.topContext().packageManager

        fun currentVersion() = packageManager().getPackageInfo(ActivityManager.topContext()?.packageName, 0).let {
            Pair(it.versionCode, it.versionName)
        }

    }

    /**
     * 作用：监听临时Android系统整体内存较低时刻（兼容android 4.0以下）
     *
     * 调用时刻：Android系统整体内存较低时
     */
    override fun onLowMemory() {
        super.onLowMemory()
    }




}