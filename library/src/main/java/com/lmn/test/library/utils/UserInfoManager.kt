package com.lmn.test.library.utils

import android.text.TextUtils
import com.blankj.utilcode.util.SPUtils
import com.lmn.test.testsdk.ui.mvp.modle.UserEntity

class UserInfoManager private constructor() {
    private val SPNAME = "fq_user"

    private val IS_LOGIN = "isLogin"

    private val TOT_TOKEN = "totToken"    //渠道方Token
    private val APP_OPEN_ID = "userId"    //渠道方UserId
    private val APP_ID = "appId"

    private val TOKEN = "token"
    private val SDK_USER_ID = "sdkUserId"     //SDKUserId
    private val USER_NICKNAME = "userNickname"
    private val USER_AVATAR = "userAvatar"
    private val USER_SEX = "userSex"
    private val USER_BALANCE = "userBalance"

    companion object {
        fun getInstance() = LazyHolder.INSTANCE
    }

    private object LazyHolder {
        val INSTANCE = UserInfoManager()
    }

    /**
     * 保存用户相关信息
     */
    fun loadUserInfo(userEntity: UserEntity?) {

        if (userEntity == null) {
            return
        }

        SPUtils.getInstance(SPNAME).put(IS_LOGIN, true)
        SPUtils.getInstance(SPNAME).put(APP_OPEN_ID, userEntity.userId)

        SPUtils.getInstance(SPNAME).put(USER_NICKNAME, userEntity.userName)
        SPUtils.getInstance(SPNAME).put(USER_AVATAR, userEntity.avatar)
        SPUtils.getInstance(SPNAME).put(USER_SEX, userEntity.sex)
        SPUtils.getInstance(SPNAME).put(USER_BALANCE, userEntity.balance)
        SPUtils.getInstance(SPNAME).put(TOT_TOKEN, userEntity.totToken)

    }

    /**
     * 获取token
     */
    fun getToken(): String {
        return SPUtils.getInstance(SPNAME).getString(TOKEN, "")
    }
    /**
     * 保存token
     */
    fun setToken(token: String?) {
        SPUtils.getInstance(SPNAME).put(TOKEN, token)
    }

    /**
     *  获取tot_token
     */
    fun getTotToken(): String {
        return SPUtils.getInstance(SPNAME).getString(TOT_TOKEN, "")
    }
    /**
     *  保存tot_token
     */
    fun setTotToken(token: String?) {
        SPUtils.getInstance(SPNAME).put(TOT_TOKEN, token)
    }

    /**
     *  获取user_id
     */
    fun getUserId(): String {
        return SPUtils.getInstance(SPNAME).getString(SDK_USER_ID, "")
    }
    /**
     *  保存user_id
     */
    fun setUserId(userId: String) {
        SPUtils.getInstance(SPNAME).put(SDK_USER_ID, userId)
    }

    /**
     *  获取app_open_id
     */
    fun getAppOpenId(): String {
        return SPUtils.getInstance(SPNAME).getString(APP_OPEN_ID, "")
    }

    /**
     *  保存app_open_id
     */
    fun setAppOpenId(openId: String?) {
        SPUtils.getInstance(SPNAME).put(APP_OPEN_ID, openId)
    }

    /**
     *  获取app_id
     */
    fun getAppId(): String {
        return SPUtils.getInstance(SPNAME).getString(APP_ID, "")
    }

    /**
     *  保存app_id
     */
    fun setAppId(appId: String) {
        SPUtils.getInstance(SPNAME).put(APP_ID, appId)
    }

    /**
     *  获取昵称
     */
    fun getUserNickname(): String {
        return SPUtils.getInstance(SPNAME).getString(USER_NICKNAME, "")
    }

    /**
     *  获取头像地址
     */
    fun getAvatar(): String {
        return SPUtils.getInstance(SPNAME).getString(USER_AVATAR)
    }

    /**
     *  获取性别
     */
    fun getUserSex(): String {
        return SPUtils.getInstance(SPNAME).getString(USER_SEX)
    }

    /**
     * 保存头像地址
     */
    fun setAvatar(imgUrl: String) {
        SPUtils.getInstance(SPNAME).put(USER_AVATAR, imgUrl)
    }

    /**
     * 保存昵称
     */
    fun setNickname(nickname: String) {
        SPUtils.getInstance(SPNAME).put(USER_NICKNAME, nickname)
    }

    /**
     * 保存性别
     */
    fun setSex(sex: String) {
        SPUtils.getInstance(SPNAME).put(USER_SEX, sex)
    }

    /**
     * 保存登录状态
     */
    fun setLogin(isLogin: Boolean) {
        SPUtils.getInstance(SPNAME).put(IS_LOGIN, isLogin)
    }

    /**
     * 是否在登录状态
     */
    fun isLogin(): Boolean {
        return (SPUtils.getInstance(SPNAME).getBoolean(IS_LOGIN, false) && !TextUtils.isEmpty(getAppOpenId())
                && !TextUtils.isEmpty(getUserId()) && !TextUtils.isEmpty(getToken()))
    }


    fun getUserBalance(): Long {
        return SPUtils.getInstance(SPNAME).getLong(USER_BALANCE)
    }

    fun clearTokenInfo() {
        setLogin(false)
        setToken(null)
        setTotToken(null)

        SPUtils.getInstance(SPNAME).remove(TOKEN, true)
        SPUtils.getInstance(SPNAME).remove(IS_LOGIN, true)
        SPUtils.getInstance(SPNAME).remove(TOT_TOKEN, true)
    }


    fun clearLoginInfo() {
        setLogin(false)
        setToken(null)
        setTotToken(null)
        setAppOpenId(null)

        SPUtils.getInstance(SPNAME).remove(TOKEN, true)
        SPUtils.getInstance(SPNAME).remove(IS_LOGIN, true)
        SPUtils.getInstance(SPNAME).remove(TOT_TOKEN, true)
        SPUtils.getInstance(SPNAME).remove(APP_OPEN_ID, true)
    }

}