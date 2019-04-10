package com.lmn.live

import android.content.Context
import android.content.Intent
import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication
import android.text.TextUtils
import android.widget.Toast
import com.blankj.utilcode.util.SPUtils
import com.blankj.utilcode.util.Utils
import com.lmn.live.ui.activity.LoginActivity
import com.lmn.live.utils.ServerUrlUtils
import com.lmn.test.library.LiveSdk
import com.lmn.test.library.utils.UserInfoManager

class BaseApplication : MultiDexApplication() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()

        Utils.init(this)
        val position = SPUtils.getInstance().getInt(ServerUrlUtils.SERVER_URL, 0)
        val urls = ServerUrlUtils.getUrls(this, position)
        val apiUrl = urls[0]     //api地址---https://api.test.kltbj.com/
        val imgUpUrl = urls[1]     //图片上传地址---https://upload.kltbj.com/
        val imgDownUrl = urls[2]       //图片下载地址---https://download.kltbj.com/
        var appId = UserInfoManager.getInstance().getAppId()       //SDK初始化需要传的appId

        if (TextUtils.isEmpty(appId)) {
            appId = "1"
        }
        val appKey = "oKXVajTOVFG42czgWbq31FyifXwN3hqZoXt/Pf5o9GxTzkNrerrrfw=="       //SDK初始化需要传的appKey

        val isHighBeauty = true

        LiveSdk.INSTANCE_SDK.initSDK(this, appId, appKey, apiUrl, imgUpUrl, imgDownUrl, isHighBeauty, object : LiveSdk.TomatoLiveSDKCallbackListener {

            override fun onGiftRechargeListener(context: Context) {
                //TOT小组跳转充值页面
                Toast.makeText(context, "充值回调", Toast.LENGTH_SHORT).show()
            }

            override fun onLoginListener(context: Context) {
                //TOT小组跳转登录页面
                context.startActivity(Intent(context, LoginActivity::class.java))
            }

            override fun onIncomeWithdrawalListener(context: Context) {
                //TOT小组跳转收益提现页面
                Toast.makeText(context, "收益提现回调", Toast.LENGTH_SHORT).show()
            }

        })
    }
}

