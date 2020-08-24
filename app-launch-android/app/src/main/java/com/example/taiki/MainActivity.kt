package com.example.taiki

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.design.widget.TabLayout
import android.support.v4.app.FragmentActivity
import android.support.v4.view.ViewPager
import android.view.KeyEvent
import com.example.taiki.model.DataModel
import com.example.taiki.viewmodel.FragmentPagerAdapter




class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataModel.init(applicationContext)
        setContentView(R.layout.activity)

        val adapter = FragmentPagerAdapter(supportFragmentManager)
        val viewPager = findViewById(R.id.viewPager) as ViewPager
        viewPager.setOffscreenPageLimit(0)
        viewPager.setAdapter(adapter)

        val tabLayout = findViewById(R.id.tabLayout) as TabLayout
        tabLayout.setupWithViewPager(viewPager)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        return if (keyCode == KeyEvent.KEYCODE_BACK) {
            // TODO: 考える
//            backOperation()
            true
        } else false
    }
}
