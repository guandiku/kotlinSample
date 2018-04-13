package com.xiamen.www.myapplication3.kotlin.view.activity

import android.annotation.SuppressLint
import android.graphics.Color
import android.support.v4.app.Fragment
import android.view.View
import android.view.WindowManager
import com.xiamen.www.myapplication3.R
import com.xiamen.www.myapplication3.kotlin.view.login.LoginFragment
import com.xiamen.www.myapplication3.kotlin.view.register.RegisterFragment
import kotlinx.android.synthetic.main.activity_login_register.*
import org.jetbrains.anko.doFromSdk

/**
 * Created by White on 2018/3/8.
 */
class LoginRegisterActivity : BaseActivity(), View.OnClickListener {


    override fun setLayoutResource(): Int = R.layout.activity_login_register

    private var loginFragment: Fragment? = null
    private var registerFragment: Fragment? = null

    @SuppressLint("NewApi")
    override fun initView() {
        doFromSdk(21) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN; View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        }
        //进来时候先初始化loginFragment界面的数据
        if (loginFragment == null) {
            loginFragment = LoginFragment()
            addFragment(loginFragment as LoginFragment, R.id.fl_fragment_content)
            showFragment(loginFragment as LoginFragment)
        }

        btn_tab_login.setOnClickListener(this)
        btn_tab_register.setOnClickListener(this)
    }

    override fun initVariable() {

    }

    override fun initData() {
    }


    override fun onClick(p0: View) {
        hideFragment()
        when (p0.id) {
            R.id.btn_tab_login -> {
                if (loginFragment == null) {
                    loginFragment = LoginFragment()
                    addFragment(loginFragment as LoginFragment, R.id.fl_fragment_content)
                }
                showFragment(loginFragment as LoginFragment)
            }
            R.id.btn_tab_register -> {
                if (registerFragment == null) {
                    registerFragment = RegisterFragment()
                    addFragment(registerFragment as RegisterFragment, R.id.fl_fragment_content)
                }
                showFragment(registerFragment as RegisterFragment)
            }
        }
    }


    private fun hideFragment() {
        if (loginFragment != null) {
            hideFragment(loginFragment as LoginFragment)
        }
        if (registerFragment != null) {
            hideFragment(registerFragment as RegisterFragment)
        }
    }

}