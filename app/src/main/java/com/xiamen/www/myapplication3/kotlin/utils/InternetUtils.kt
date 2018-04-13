package com.xiamen.www.myapplication3.kotlin.utils

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.provider.Settings
import android.support.v7.app.AlertDialog
import android.util.Log
import android.widget.TextView

/**
 * Created by White on 2018/3/7.
 */
object  InternetUtils{
    /**
     * 判断网络情况
     *
     * @param context 上下文
     * @return false 表示没有网络 true 表示有网络
     */
    fun isNetworkAvalible(context: Context): Boolean {
        // 获得网络状态管理器
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (connectivityManager == null) {
            return false
        } else {
            // 建立网络数组
            val net_info = connectivityManager.allNetworkInfo

            if (net_info != null) {
                for (i in net_info.indices) {
                    // 判断获得的网络状态是否是处于连接状态
                    if (net_info[i].state == NetworkInfo.State.CONNECTED) {
                        return true
                    }
                }
            }
        }
        return false
    }

    /**
     * 获取当前app的版本号（版本号在build.gradle中的versionName中显示）
     */
    fun getVersion(context: Context): String {
        var version = "未知版本"
        val manager = context.packageManager
        try {
            val packageInfo = manager.getPackageInfo(context.packageName, 0)
            version = packageInfo.versionName
        } catch (e: PackageManager.NameNotFoundException) {
            //e.printStackTrace(); //如果找不到对应的应用包信息, 就返回"未知版本"
        }

        return version
    }

    // 如果没有网络，则弹出网络设置对话框
    fun checkNetwork(activity: Activity) {
        if (!isNetworkAvalible(activity)) {
            val msg = TextView(activity)
            msg.text = "当前没有可以使用的网络，请设置网络！"
            AlertDialog.Builder(activity).setTitle("网络状态提示").setView(msg).setPositiveButton("确定") { dialog, whichButton ->
                // 跳转到设置界面
                activity.startActivityForResult(Intent(Settings.ACTION_WIRELESS_SETTINGS), 0)
            }.create().show()
        }
        return
    }

    /**
     * 判断网络是否连接
     */
    fun netState(context: Context): Boolean {
        val connManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        // 获取代表联网状态的NetWorkInfo对象
        val networkInfo = connManager.activeNetworkInfo
        // 获取当前的网络连接是否可用
        var available = false
        try {
            available = networkInfo.isAvailable
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }

        if (available) {
            Log.i("通知", "当前的网络连接可用")
            return true
        } else {
            Log.i("通知", "当前的网络连接可用")
            return false
        }
    }

    /**
     * 在连接到网络基础之上,判断设备是否是SIM网络连接
     *
     * @param context
     * @return
     */
    fun IsMobileNetConnect(context: Context): Boolean {
        try {
            val connManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val state = connManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).state
            return if (NetworkInfo.State.CONNECTED == state)
                true
            else
                false
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }

    }
}