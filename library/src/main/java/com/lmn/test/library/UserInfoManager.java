package com.lmn.test.library;

import android.text.TextUtils;

import com.blankj.utilcode.util.SPUtils;


public class UserInfoManager {

    private final String SPNAME = "fq_user";

    private final String IS_LOGIN = "isLogin";

    private final String TOT_TOKEN = "totToken";    //渠道方Token
    private final String APP_OPEN_ID = "userId";    //渠道方UserId
    private final String APP_ID = "appId";

    private final String TOKEN = "token";
    private final String SDK_USER_ID = "sdkUserId";     //SDKUserId
    private final String USER_NICKNAME = "userNickname";
    private final String USER_AVATAR = "userAvatar";
    private final String USER_SEX = "userSex";
    private final String USER_BALANCE = "userBalance";

    private UserInfoManager() {

    }

    public static UserInfoManager getInstance() {
        return LazyHolder.INSTANCE;
    }

    public void loadUserInfo(UserEntity userEntity) {

        if (userEntity == null) {
            return;
        }

        SPUtils.getInstance(SPNAME).put(IS_LOGIN, true);
        SPUtils.getInstance(SPNAME).put(APP_OPEN_ID, userEntity.getUserId());

        SPUtils.getInstance(SPNAME).put(USER_NICKNAME, userEntity.getName());
        SPUtils.getInstance(SPNAME).put(USER_AVATAR, userEntity.getAvatar());
        SPUtils.getInstance(SPNAME).put(USER_SEX, userEntity.getSex());
        SPUtils.getInstance(SPNAME).put(USER_BALANCE, userEntity.getBalance());
        SPUtils.getInstance(SPNAME).put(TOT_TOKEN, userEntity.getTotToken());

    }

    public String getToken() {
        return SPUtils.getInstance(SPNAME).getString(TOKEN, "");
    }

    public void setToken(String token) {
        SPUtils.getInstance(SPNAME).put(TOKEN, token);
    }

    public String getTotToken() {
        return SPUtils.getInstance(SPNAME).getString(TOT_TOKEN, "");
    }

    public void setTotToken(String token) {
        SPUtils.getInstance(SPNAME).put(TOT_TOKEN, token);
    }

    public String getUserId() {
        boolean isLogin = SPUtils.getInstance(SPNAME).getBoolean(IS_LOGIN, false);
        String userId = SPUtils.getInstance(SPNAME).getString(SDK_USER_ID, "");
        return isLogin ? userId : "";
    }

    public void setUserId(String userId) {
        SPUtils.getInstance(SPNAME).put(SDK_USER_ID, userId);
    }

    public String getAppOpenId() {
        return SPUtils.getInstance(SPNAME).getString(APP_OPEN_ID, "");
    }

    public void setAppOpenId(String openId) {
        SPUtils.getInstance(SPNAME).put(APP_OPEN_ID, openId);
    }

    public String getAppId() {
        return SPUtils.getInstance(SPNAME).getString(APP_ID, "");
    }

    public void setAppId(String appId) {
        SPUtils.getInstance(SPNAME).put(APP_ID, appId);
    }

    public String getUserNickname() {
        return SPUtils.getInstance(SPNAME).getString(USER_NICKNAME, "");
    }

    public String getAvatar() {
        return SPUtils.getInstance(SPNAME).getString(USER_AVATAR);
    }

    public String getUserSex() {
        return SPUtils.getInstance(SPNAME).getString(USER_SEX);
    }

    public void setAvatar(String imgUrl) {
        SPUtils.getInstance(SPNAME).put(USER_AVATAR, imgUrl);
    }

    public void setNickname(String nickname) {
        SPUtils.getInstance(SPNAME).put(USER_NICKNAME, nickname);
    }

    public void setSex(String sex) {
        SPUtils.getInstance(SPNAME).put(USER_SEX, sex);
    }

    public void setLogin(boolean isLogin) {
        SPUtils.getInstance(SPNAME).put(IS_LOGIN, isLogin);
    }

    public boolean isLogin() {
        return SPUtils.getInstance(SPNAME).getBoolean(IS_LOGIN, false) && !TextUtils.isEmpty(getAppOpenId())
                && !TextUtils.isEmpty(getUserId()) && !TextUtils.isEmpty(getToken());
    }

    public long getUserBalance() {
        return SPUtils.getInstance(SPNAME).getLong(USER_BALANCE);
    }

    public void clearTokenInfo() {
        setLogin(false);
        setToken(null);
        setTotToken(null);

        SPUtils.getInstance(SPNAME).remove(TOKEN, true);
        SPUtils.getInstance(SPNAME).remove(IS_LOGIN, true);
        SPUtils.getInstance(SPNAME).remove(TOT_TOKEN, true);
    }

    public void clearLoginInfo() {
        setLogin(false);
        setToken(null);
        setTotToken(null);
        setAppOpenId(null);

        SPUtils.getInstance(SPNAME).remove(TOKEN, true);
        SPUtils.getInstance(SPNAME).remove(IS_LOGIN, true);
        SPUtils.getInstance(SPNAME).remove(TOT_TOKEN, true);
        SPUtils.getInstance(SPNAME).remove(APP_OPEN_ID, true);
    }

    public boolean isUpdateToken() {
        return isLogin() && TextUtils.isEmpty(getToken());
    }

    private static class LazyHolder {

        private static final UserInfoManager INSTANCE = new UserInfoManager();
    }
}
