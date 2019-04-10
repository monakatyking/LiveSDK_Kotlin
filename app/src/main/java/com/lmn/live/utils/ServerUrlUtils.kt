package com.lmn.live.utils

import android.content.Context
import com.lmn.live.R

/**
 * @author HuXiangLiang
 * @name TomatoLive
 * @class name：com.tomatolive.view
 * @class describe
 * @time 2018/12/12 0012 16:39
 * @change
 * @chang time
 * @class describe
 */

object ServerUrlUtils {

    val SERVER_URL = "serverUrl"

    fun getUrls(context: Context, position: Int): Array<String> {
        when (position) {
            0 -> return context.resources.getStringArray(R.array.address_change_pre_1)
            1 -> return context.resources.getStringArray(R.array.address_change_pre_2)
            2 -> return context.resources.getStringArray(R.array.address_change_test)
            3 -> return context.resources.getStringArray(R.array.address_change_wang)
            4 -> return context.resources.getStringArray(R.array.address_change_wang35)
            5 -> return context.resources.getStringArray(R.array.address_change_yc)
            else -> return context.resources.getStringArray(R.array.address_change_pre_1)
        }

    }


}
