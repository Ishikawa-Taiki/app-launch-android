package com.example.taiki

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import com.example.taiki.model.ApplicationData
import com.example.taiki.model.DataModel
import com.example.taiki.viewmodel.ListViewAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataModel.init(applicationContext)
        setMainScreenMode()
    }

    private fun setMainScreenMode() {
        setContentView(R.layout.activity_main)

        val adapter = ListViewAdapter()
        val rv = findViewById(R.id.listView) as RecyclerView
        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter
        adapter.setOnItemClickListener(object : ListViewAdapter.onItemClickListener {
            override fun onItemClick(data: ApplicationData) {
//                data.packageName?.let {
//                    val intent = DataModel.getAppIntent(it) ?: DataModel.getStoreIntent(it)
//                    startActivity(intent)
//                }
                setSubScreenMode()
            }
        })
    }

    private fun setSubScreenMode() {
        setContentView(R.layout.activity_sub)

        val adapter = ListViewAdapter()
        val rv = findViewById(R.id.listView) as RecyclerView
        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter
        adapter.setOnItemClickListener(object : ListViewAdapter.onItemClickListener {
            override fun onItemClick(data: ApplicationData) {
                data.packageName?.let {
                    val intent = DataModel.getAppIntent(it) ?: DataModel.getStoreIntent(it)
                    startActivity(intent)
                }
            }
        })

        val returnButton = findViewById<Button>(R.id.return_button)
        returnButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                setMainScreenMode()
            }
        })
    }
}
