package com.lmn.live.ui.activity
import android.Manifest
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import com.lmn.live.R
import com.lmn.test.library.ui.fragment.FragmentMy
import com.lmn.test.library.ui.view.dialog.MainFragmentPagerAdapter
import com.lmn.test.livebroadcast.base.BaseActivity
import com.lmn.test.livebroadcast.ui.fragment.FragmentOther
import com.tbruyelle.rxpermissions2.RxPermissions
import kotlinx.android.synthetic.main.activity_main.*
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem
import me.majiajie.pagerbottomtabstrip.item.NormalItemView

class MainActivity : BaseActivity() {
    override fun initView(savedInstanceState: Bundle?) {
        RxPermissions(this)
                .request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe {
                    if (it) {
                        //todo 礼物下载到本地需要相应的动态权限

                    } else {
                        finish()
                    }
                }

        tab.custom()
                .addItem(newItem(R.mipmap.ic_tab_live, R.mipmap.ic_tab_live_red, getString(R.string.tomato)))
                .addItem(newItem(R.mipmap.ic_tab_live, R.mipmap.ic_tab_live_red, getString(R.string.live)))
                .addItem(newItem(R.mipmap.ic_tab_my, R.mipmap.ic_tab_my_red, getString(R.string.my)))
                .build()

        viewPager.adapter = MainFragmentPagerAdapter(supportFragmentManager, getFragments())
        viewPager.currentItem = 1
        viewPager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == 1) {
                    //todo 暂不使用小窗口模式
                }
            }
        })
    }

    private fun newItem(drawableNomal: Int, drawableSelect: Int, text: String?): BaseTabItem? {
        val normalItemView: NormalItemView = NormalItemView(mContext)
        normalItemView.initialize(drawableNomal, drawableSelect, text)
        normalItemView.setTextDefaultColor(ContextCompat.getColor(this, R.color.fq_colorBlack))
        normalItemView.setTextCheckedColor(ContextCompat.getColor(this, R.color.fq_tab_menu_text_select_color))

        return normalItemView
    }

    private fun getFragments(): MutableList<Fragment> {
        val list = mutableListOf<Fragment>()

        list.add(FragmentOther())
//        list.add(FragmentLiveHome.newInstance())
        list.add(FragmentMy())
        return list
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initListener() {
    }

    override fun initData() {
    }

}
