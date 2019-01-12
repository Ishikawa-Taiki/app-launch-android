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
                Toast.makeText(this@MainActivity, data.title+":"+data.detail, Toast.LENGTH_SHORT).show()
            }
        })
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
