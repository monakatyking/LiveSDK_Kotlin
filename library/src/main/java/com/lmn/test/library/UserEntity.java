package com.lmn.test.library;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserEntity implements Serializable,Comparable<UserEntity> {

    private String id;
    private String userId;
    private String token;
    private String phone;
    @SerializedName("userName")
    private String name;
    private String avatar;
    private String sex;
    private String userType;
    private String type;
    private String status;
    private String number;
    private String userSig;
    private String expGrade;//等级

    private String totToken;

    private String totResult;

    private long balance = 0;

    private int follow = 0;
    private int fans = 0;
    private int guardType;//守护等级

    private int weight ;//权重

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getGuardType() {
        return guardType;
    }

    public void setGuardType(int guardType) {
        this.guardType = guardType;
    }

    public UserEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUserSig() {
        return userSig;
    }

    public void setUserSig(String userSig) {
        this.userSig = userSig;
    }

    public int getAttention() {
        return follow;
    }

    public void setAttention(int attention) {
        this.follow = attention;
    }

    public int getFans() {
        return fans;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getExpGrade() {
        return expGrade;
    }

    public void setExpGrade(String expGrade) {
        this.expGrade = expGrade;
    }

    public String getTotToken() {
        return totToken;
    }

    public void setTotToken(String totToken) {
        this.totToken = totToken;
    }

    public String getTotResult() {
        return totResult;
    }

    public void setTotResult(String totResult) {
        this.totResult = totResult;
    }

    @Override
    public int compareTo(@NonNull UserEntity o) {
        return this.weight > o.weight ? -1 : 1;
    }
}
