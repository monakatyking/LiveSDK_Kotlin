package com.lmn.test.library.ui.view.dialog

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class MainFragmentPagerAdapter(private var fm: FragmentManager?, private var fragments: MutableList<Fragment>) : FragmentPagerAdapter(fm) {
    private var currentFragment: Fragment? = null

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

}