package com.example.taiki.viewmodel

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.taiki.MainFragment
import android.os.Bundle
import com.example.taiki.MainFragment2


class FragmentPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val tabTitles = arrayOf<CharSequence>("タブ1", "タブ2")

    override fun getPageTitle(position: Int): CharSequence? {
        return tabTitles[position]
    }

    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> return MainFragment()
            1 -> return MainFragment2()
            else -> return null
        }
    }

    override fun getCount(): Int {
        return tabTitles.size
    }
}