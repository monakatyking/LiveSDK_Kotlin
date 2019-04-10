package com.lmn.test.testsdk.ui.mvp.modle

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UserEntity(var id: String, var userId: String, var token: String, var phone: String, var userName: String,
                      var avatar: String, var sex: String, var userType: String, var type: String, var status: String,
                      var number: String, var userSig: String, var expGrade: String, var totToken: String,
                      var totResult: String, var balance: Long, var follow: Int, var fans: Int, var guardType: Int,
                      var weight: Int) : Comparator<UserEntity> {
    override fun compare(o1: UserEntity?, o2: UserEntity?): Int {
        return if (o1!!.weight > o2!!.weight) -1 else 1
    }

}

