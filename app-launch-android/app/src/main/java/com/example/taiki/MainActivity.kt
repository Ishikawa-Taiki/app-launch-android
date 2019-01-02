package com.example.taiki

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView



class MainActivity : AppCompatActivity() {

//    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
//        when (item.itemId) {
//            R.id.navigation_home -> {
//                val input = inputData[0]
////                message.setText(input.second)
//                startActivity(appLinkInfo.getPackageInfo(input.second)?.intent)
//                return@OnNavigationItemSelectedListener true
//            }
//            R.id.navigation_dashboard -> {
//                val input = inputData[1]
////                message.setText(input.second)
//                startActivity(appLinkInfo.getPackageInfo(input.second)?.intent)
//                return@OnNavigationItemSelectedListener true
//            }
//            R.id.navigation_notifications -> {
//                val input = inputData[2]
////                message.setText(input.second)
//                startActivity(appLinkInfo.getPackageInfo(input.second)?.intent)
//                return@OnNavigationItemSelectedListener true
//            }
//        }
//        false
//    }

    private val inputData: Array<Pair<String, String>> = arrayOf(
        Pair("Chrome", "com.android.chrome"),
        Pair("Gmail", "com.google.android.gm"),
        Pair("Youtube", "com.google.android.youtube")
    )
    private lateinit var appLinkInfo: AppLinkInfo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        appLinkInfo = AppLinkInfo(getPackageManager())
        inputData.forEach {
            appLinkInfo.addPackageInfo(it.second)
        }


        val rv = findViewById(R.id.listView) as RecyclerView
        val adapter = ListViewAdapter(createDataset())

        val llm = LinearLayoutManager(this)

        rv.setHasFixedSize(true)

        rv.layoutManager = llm

        rv.adapter = adapter
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun createDataset(): List<RowData> {

        val dataset = ArrayList<RowData>()
        for (i in 0..49) {
            val data = RowData()
            data.title = inputData[i%3].first
            data.detail = inputData[i%3].second
            dataset.add(data)
        }
        return dataset
    }
}
