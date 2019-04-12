package com.lmn.test.library.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.afollestad.materialdialogs.MaterialDialog
import com.blankj.utilcode.util.SPUtils
import com.lmn.live.R
import com.lmn.live.utils.ServerUrlUtils
import com.lmn.test.library.LiveSdk
import com.lmn.test.library.utils.UserInfoManager
import kotlinx.android.synthetic.main.fragment_my.*

class FragmentMy : Fragment() {
    private var loadingDialog: MaterialDialog? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_my, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        createLoadingDialog()
        tv_channel.text = getChannelStr()
        cb_box.isChecked = LiveSdk.INSTANCE_SDK.IS_HIGH_BEAUTY

        val position = SPUtils.getInstance().getInt(ServerUrlUtils.SERVER_URL, 0)
        tv_address.text = getUrlAddress(position)

        initLoginInfo()
    }

    /**
     * 初始化登录信息
     */
    private fun initLoginInfo() {
        if(UserInfoManager.getInstance().isLogin()){
//            GlideUtils.loadAvatar(activity, ivAvatar, UserInfoManager.getInstance().getAvatar(), 6,
//                    ContextCompat.getColor(activity!!, com.tomatolive.library.R.color.fq_colorWhite))
        } else{

        }
    }

    /**
     * 获取url环境
     */
    private fun getUrlAddress(position: Int): CharSequence? {
        return try {
            val stringArray = resources.getStringArray(R.array.address_change_url_name)
            stringArray[position]
        } catch (e: Exception) {
            ""
        }
    }

    /**
     * 获取appid
     */
    private fun getChannelStr(): CharSequence? {
        val sb = StringBuffer()
        return sb.append("渠道号：")
                .append(UserInfoManager.getInstance().getAppId()).toString()
    }

    /**
     * 创建弹窗
     */
    private fun createLoadingDialog() {
        context?.let {
            val builder = MaterialDialog.Builder(it).progress(true, 0).build()
            builder.setContent(R.string.login_exiting)
        }
    }


}