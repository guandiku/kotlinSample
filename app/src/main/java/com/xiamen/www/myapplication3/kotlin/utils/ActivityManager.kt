package com.xiamen.www.myapplication3.kotlin.utils

import android.app.Activity
import android.app.Application
import android.os.Bundle

/**
 * Created by White on 2018/3/7.
 */
object ActivityManager{
    private val activities = mutableListOf<Activity>()

    fun finishAllActivity() {
        activities.forEach { it.finish() }
        activities.clear()
    }

    fun onTerminate() = activities.clear()

    /**
     * 返回当前界面最顶层的activity，若没有，则返回null
     */
    fun topActivity() = activities.lastOrNull()

    /**
     * 返回最顶层的activity，若没有，则返回application
     */

    fun topContext() = topActivity() ?: AppBase.context

    val callback = object : Application.ActivityLifecycleCallbacks {
        override fun onActivityPaused(activity: Activity) {
        }

        override fun onActivityResumed(activity: Activity) {
        }

        override fun onActivityStarted(activity: Activity) {
        }

        override fun onActivityDestroyed(activity: Activity) {
            activities.remove(activity)
        }

        override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle?) {
        }

        override fun onActivityStopped(activity: Activity) {
        }

        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
            activities.add(activity)
            AppBase.context = activity
        }
    }
}