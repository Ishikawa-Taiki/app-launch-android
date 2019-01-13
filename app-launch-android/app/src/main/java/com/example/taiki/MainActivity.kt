package com.example.taiki

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.taiki.model.ApplicationData
import com.example.taiki.model.DataModel
import com.example.taiki.viewmodel.ListViewAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DataModel.init(applicationContext)

        val rv = findViewById(R.id.listView) as RecyclerView
        val adapter = ListViewAdapter()

        val llm = LinearLayoutManager(this)

        rv.setHasFixedSize(true)

        rv.layoutManager = llm

        rv.adapter = adapter
        adapter.setOnItemClickListener(object : ListViewAdapter.onItemClickListener {
            override fun onItemClick(data: ApplicationData) {
                data.packageName?.let {
                    val intent = DataModel.getAppIntent(it) ?: DataModel.getStoreIntent(it)
                    startActivity(intent)
                }
            }
        })
    }
}
