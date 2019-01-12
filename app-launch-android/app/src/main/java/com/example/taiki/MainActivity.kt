package com.example.taiki

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

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
        adapter.setOnItemClickListener(object : ListViewAdapter.onItemClickListener {
            override fun onItemClick(data: RowData) {
                data.detail?.let { startActivity(appLinkInfo.getPackageInfo(it)?.intent) }
            }
        })
    }

    private fun createDataset(): List<RowData> {
        val dataset = inputData.map {
            val data = RowData()
            data.title = it.first
            data.detail = it.second
            data
        }
        return dataset
    }
}
