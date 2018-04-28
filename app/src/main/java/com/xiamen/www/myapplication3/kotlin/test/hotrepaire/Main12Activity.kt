package com.xiamen.www.myapplication3.kotlin.test.hotrepaire

import android.Manifest
import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.Toast
import com.xiamen.www.myapplication3.R
import org.jetbrains.anko.find
import permissions.dispatcher.NeedsPermission
import permissions.dispatcher.OnPermissionDenied
import permissions.dispatcher.RuntimePermissions
import android.system.Os.mkdir
import com.xiamen.www.myapplication3.kotlin.module.appl.TinkerManager
import java.io.File





@RuntimePermissions
class Main12Activity : AppCompatActivity() {

    private val FILE_END = ".apk"//文件后缀


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main12)

        fixWithPermissionCheck()

         //storage/emulated/0/Android/data/com.example.ggxiaozhi.tinker/cache/tpatch/
        val address=Environment.getExternalStorageDirectory().toString()
//        val FILEDIR=externalCacheDir.absolutePath + "/tpatch/"
        val FILEDIR=address + "/tpatch/"
        //创建路径对应的文件夹
        val file = File(FILEDIR)
        if (!file.exists()) {
            file.mkdir()
        }

    }

    /***
     * 权限处理
     */
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        // NOTE: delegate the permission handling to generated function
        onRequestPermissionsResult(requestCode, grantResults)
    }


    @NeedsPermission(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
    fun fix() {
        find<Button>(R.id.button).setOnClickListener {
            val a = TestClass().testFix()
            Toast.makeText(Main12Activity@ this, 1 / a, Toast.LENGTH_LONG).show()
        }


        find<Button>(R.id.button2).setOnClickListener {
            FixDexUtils.loadFixedDex(this)
        }


        find<Button>(R.id.button_fix).setOnClickListener {
            println("啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊")
            TinkerManager.loadPatch(getPatchName())
        }

    }



    fun getPatchName(): String {
//        return externalCacheDir.absolutePath + "/tpatch/"+"tinker"+FILE_END
        val address=Environment.getExternalStorageDirectory().toString()
        return address + "/tpatch/"+"tinker"+FILE_END
    }


}
