package com.xiamen.www.myapplication3.kotlin.module.appl;

import android.content.Context;

import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.app.ApplicationLike;

/**
 * Created by White on 2018/4/20.
 */

public class TinkerManager {

    private static boolean isInstalled = false;//是否已经初始化标志位
    private static ApplicationLike mApplicationLike;

    /**
     * 完成Tinker初始化
     *
     * @param applicationLike
     */
    public static void installedThinker(ApplicationLike applicationLike){
        mApplicationLike=applicationLike;
        if (isInstalled) return;
        TinkerInstaller.install(mApplicationLike);
        isInstalled=true;
    }

    /**
     * 完成patch文件的加载
     *
     * @param path 补丁文件路径
     */
    public static void loadPatch(String path){
        if (Tinker.isTinkerInstalled()){
            //是否已经安装过
            TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(),path);
        }
    }

    public static Context getApplicationContext(){
        if(mApplicationLike!=null){
            return mApplicationLike.getApplication().getApplicationContext();
        }
        return null;
    }

}


