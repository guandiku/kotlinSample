package com.xiamen.www.myapplication3.kotlin.view.register

import android.arch.lifecycle.ViewModelProviders
import android.support.v4.content.ContextCompat
import com.jakewharton.rxbinding2.view.clicks
import com.jakewharton.rxbinding2.widget.textChanges
import com.mtool.toolslib.core.ioInAndroidOut
import com.xiamen.www.myapplication3.R
import com.xiamen.www.myapplication3.kotlin.view.fragment.BaseFGM.BaseFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.Observables
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_register.*
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.textColor
import java.util.concurrent.TimeUnit


/**
 * Created by White on 2018/3/8.
 */
class RegisterFragment : BaseFragment() {

    private lateinit var vm: RegisterVM

    override fun setLayoutResourceID(): Int = R.layout.fragment_register


    override fun initData() {
        vm = ViewModelProviders.of(this).get(RegisterVM::class.java)
        /**
         * 输入手机号码,判断长度为11位
         */
        val phoneNumber = et_input_phone_number.textChanges()
                .skip(1)
                .debounce(500, TimeUnit.MICROSECONDS)
                .map {
                    it.length == 11
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        phoneNumber.subscribe {
            et_input_phone_number.textColor = if (it) {
                ContextCompat.getColor(activity, R.color.black)
            } else {
                ContextCompat.getColor(activity, R.color.red)
            }
        }.addTo(disposable)
        /**
         * 获取验证码
         */
        val messageCode = message_code.textChanges()
                .skip(1)
                .debounce(500, TimeUnit.MICROSECONDS)
                .map {
                    it.length == 4
                }
        messageCode.ioInAndroidOut()
                .subscribe {

                }.addTo(disposable)

        /**
         * 请输入密码
         */
        val password = et_input_password.textChanges()
                .skip(1)
                .debounce(500, TimeUnit.MICROSECONDS)
                .map {
                    it.length > 5 && firstCharacter(it.toString()) && it.toString() == et_check_password.text.toString()
                }
        password.ioInAndroidOut().subscribe {
            et_input_password.textColor = if (it) {
                ContextCompat.getColor(activity, R.color.black)
            } else {
                ContextCompat.getColor(activity, R.color.red)
            }
            et_check_password.textColor = if (it) {
                ContextCompat.getColor(activity, R.color.black)
            } else {
                ContextCompat.getColor(activity, R.color.red)
            }
        }.addTo(disposable)

        /**
         * 请确认密码
         */
        val rePassword = et_check_password.textChanges()
                .skip(1)
                .debounce(500, TimeUnit.MICROSECONDS)
                .map {
                    it.length > 5 && firstCharacter(it.toString()) && it.toString() == et_input_password.text.toString()
                }.ioInAndroidOut()
        rePassword.subscribe {
            et_input_password.textColor = if (it) {
                ContextCompat.getColor(activity, R.color.black)
            } else {
                ContextCompat.getColor(activity, R.color.red)
            }
            et_check_password.textColor = if (it) {
                ContextCompat.getColor(activity, R.color.black)
            } else {
                ContextCompat.getColor(activity, R.color.red)
            }
        }.addTo(disposable)

        /**
         * 注册按钮
         */
        btn_register_commit.clicks()
                .map {
                    et_input_password.text.toString() == et_check_password.text.toString()
                }
                .debounce(500, TimeUnit.MICROSECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    //注册
                    if (it) {
                        this@RegisterFragment.toast("准备跳转到注册页面")
                    } else {
                        this@RegisterFragment.toast("请确认密码是否相同")
                    }
                }.addTo(disposable)

        Observables.combineLatest(phoneNumber, messageCode, rePassword, { phoneNumber, messageCode, rePassword ->
            println("Check ==> " + "phoneNumber----->${if (phoneNumber) "T" else "F"}")
            println("Check ==> " + "messageCode----->${if (messageCode) "T" else "F"}")
//            println("Check ==> " + "password----->${if (password) "T" else "F"}")
            println("Check ==> " + "rePassword----->${if (rePassword) "T" else "F"}")
            println("==============================================================")
            phoneNumber && messageCode && rePassword

        }).ioInAndroidOut()
                .subscribe {
                    btn_register_commit.isEnabled = it
                    btn_register_commit.text = if (it) "立即注册" else "填妥后注册"
                }.addTo(disposable)

    }


    override fun initView() {

    }


    private fun firstCharacter(content: String): Boolean {
        return if (content.isNotEmpty()) {
            val first = content[0]
            first in 'a'..'z' || first in 'A'..'Z'
        } else {
            false
        }
    }


    private fun getSecurityCode() {
//        vm.getSecurityCode()

    }
}