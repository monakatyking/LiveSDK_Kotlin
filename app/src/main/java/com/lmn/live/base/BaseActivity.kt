package com.lmn.test.livebroadcast.base

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    protected var simpleName: String? = null
    protected var mActivity: Activity? = null
    protected var mContext: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init(savedInstanceState)
    }

    private fun init(savedInstanceState: Bundle?) {
        simpleName = javaClass.simpleName
        mActivity = this
        mContext = this

        setContentView(this.getLayoutId())
        initView(savedInstanceState)
        initData()
        initListener()
    }

    abstract fun initView(savedInstanceState: Bundle?)
    abstract fun getLayoutId(): Int
    abstract fun initListener()
    abstract fun initData()

    fun startActivity(clazz: Class<out Activity>) {
        val intent = Intent(mContext, clazz)
        startActivity(intent)
    }

}