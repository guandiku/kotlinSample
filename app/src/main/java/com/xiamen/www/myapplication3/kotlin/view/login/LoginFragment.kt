package com.xiamen.www.myapplication3.kotlin.view.login

import android.support.v4.content.ContextCompat
import com.jakewharton.rxbinding2.view.RxView
import com.jakewharton.rxbinding2.widget.RxTextView
import com.jakewharton.rxbinding2.widget.textChanges
import com.mtool.toolslib.core.androidInAndroidOut
import com.xiamen.www.myapplication3.R
import com.xiamen.www.myapplication3.kotlin.view.fragment.BaseFGM.BaseFragment
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_login.*
import org.jetbrains.anko.textColor
import java.util.concurrent.TimeUnit
import android.R.attr.button
import android.util.Log
import com.jakewharton.rxbinding2.view.clicks
import com.mtool.toolslib.base.core.ext.TAG


/**
 * Created by White on 2018/3/8.
 */
class LoginFragment : BaseFragment() {


    override fun initView() {

    }

    override fun setLayoutResourceID(): Int = R.layout.fragment_login

    override fun initData() {
//        val view = getContentView()
//        val etPhoneNumber = view.findViewById(R.id.et_input_phone_number) as EditText
//        val etPassword = view.findViewById(R.id.et_input_password) as EditText
//        val btnLogin = view.find<Button>(R.id.btn_login)


        et_input_phone_number.textChanges()
                .skip(1)
                .debounce(500, TimeUnit.MICROSECONDS)
                .map { it.length == 11 }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    et_input_phone_number.textColor = if (it) {
                        ContextCompat.getColor(activity, R.color.black)
                    } else {
                        ContextCompat.getColor(activity, R.color.red)
                    }

                }.addTo(disposable)

        et_input_password.textChanges()
                .skip(1)
                .debounce(500, TimeUnit.MICROSECONDS)
                .map {
                    it.length > 5
                }.androidInAndroidOut()
                .subscribe {
                    et_input_password.textColor = if (it) ContextCompat.getColor(activity, R.color.black) else ContextCompat.getColor(activity, R.color.red)
                }.addTo(disposable)


        val phoneNumberObservable = RxTextView.textChanges(et_input_phone_number).skip(1)
        val etPasswordObservable = RxTextView.textChanges(et_input_password).skip(1)

        val isFillComplete: Observable<Boolean> = Observable.combineLatest(
                phoneNumberObservable,
                etPasswordObservable,
                BiFunction { phoneNumber, password -> phoneNumber.isNotEmpty() and password.isNotEmpty() }
        )

        isFillComplete.subscribe {
            btn_login.isEnabled = it
        }

       btn_login.clicks()
               .throttleFirst(2,TimeUnit.SECONDS)
               .subscribe {
                   Log.d(TAG(),"yes")
               }



    }


    fun firstCharacter(userName: String): Boolean {
        return if (userName.isNotEmpty()) {
            val x = userName[0]
            x in 'a'..'z' || x in 'A'..'Z'
        } else {
            false
        }
    }


}