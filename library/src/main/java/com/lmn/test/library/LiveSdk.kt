package com.lmn.test.library

import android.app.Application
import android.content.Context
import com.blankj.utilcode.util.Utils
import com.lmn.test.library.utils.UserInfoManager
import com.youdao.sdk.app.YouDaoApplication
import org.litepal.LitePal

class LiveSdk private constructor(){
    /***
     * TOT小组Key
     */
    private val YOUDAO_KEY = "1fdd2bb053fdb5bf"
    private var application: Application? = null
    var sdkCallbackListener: TomatoLiveSDKCallbackListener? = null
    var API_URL = ""
    var IMG_UP_URL = ""
    var IMG_DOWN_URL = ""
    var APP_KEY = ""
    var APP_ID = ""
    var IS_HIGH_BEAUTY = false //是否显示高级美颜

    companion object {
        val INSTANCE_SDK by lazy (mode = LazyThreadSafetyMode.SYNCHRONIZED){
            LiveSdk()
        }
    }

    /***
     * 初始化SDK
     * @param application
     * @param apiUrl    服务器API接口地址
     * @param imgUpUrl  图片上传地址
     * @param imgDownUrl    图片下载地址
     * @param isHighBeauty    是否使用高级美颜
     * @param callbackListener  监听回调
     */
    fun initSDK(application: Application, appId: String, appKey: String, apiUrl: String,
                imgUpUrl: String, imgDownUrl: String, isHighBeauty: Boolean, callbackListener: TomatoLiveSDKCallbackListener) {
        this.application = application
        this.sdkCallbackListener = callbackListener
        this.APP_ID = appId
        this.APP_KEY = appKey
        this.API_URL = apiUrl
        this.IMG_UP_URL = imgUpUrl
        this.IMG_DOWN_URL = imgDownUrl
        this.IS_HIGH_BEAUTY = isHighBeauty
        UserInfoManager.getInstance().setAppId(appId)
        LitePal.initialize(application)    //数据库
        Utils.init(application)    //工具类
        YouDaoApplication.init(application, YOUDAO_KEY)    //有道翻译
        //        initAppStatusListener(application);
    }



    interface TomatoLiveSDKCallbackListener {

        /***
         * 礼物充值回调
         * @param context
         */
        fun onGiftRechargeListener(context: Context)

        /***
         * 登录回调
         * @param context
         */
        fun onLoginListener(context: Context)

        /***
         * 收益提现回调
         * @param context
         */
        fun onIncomeWithdrawalListener(context: Context)

    }

}