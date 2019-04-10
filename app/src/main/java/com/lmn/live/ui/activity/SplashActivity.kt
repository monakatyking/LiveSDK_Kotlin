package com.lmn.live.ui.activity

import android.os.Bundle
import com.lmn.live.R
import com.lmn.test.livebroadcast.base.BaseActivity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class SplashActivity : BaseActivity() {
    override fun initView(savedInstanceState: Bundle?) {
        Observable.timer(5, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe {
                    startActivity(MainActivity::class.java)
                }


    }


    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun initListener() {
    }

    override fun initData() {
    }

}