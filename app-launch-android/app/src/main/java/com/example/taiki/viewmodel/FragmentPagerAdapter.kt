package com.example.taiki.viewmodel

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.taiki.MainFragment
import com.example.taiki.InstalledAppsFragment


class FragmentPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private val tabTitles = arrayOf<CharSequence>("お買い物", "アプリ一覧")

    override fun getPageTitle(position: Int): CharSequence? {
        return tabTitles[position]
    }

    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> return MainFragment()
            1 -> return InstalledAppsFragment()
            else -> return null
        }
    }

    override fun getCount(): Int {
        return tabTitles.size
    }
}