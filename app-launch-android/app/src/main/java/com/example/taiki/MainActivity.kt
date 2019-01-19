package com.example.taiki

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import com.example.taiki.viewmodel.RecyclerViewAdapter
import android.support.v7.widget.DividerItemDecoration
import android.view.KeyEvent
import com.example.taiki.model.*
import java.util.*


class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataModel.init(applicationContext)
        resetScreen()
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun resetScreen() {
        setContentView(R.layout.activity)
        val titleName = DataModel.peekScreen()
        setTitle(titleName ?: getString(R.string.app_name))

        val adapter = RecyclerViewAdapter()
        val rv = findViewById(R.id.listView) as RecyclerView
        val llm = LinearLayoutManager(this)
        rv.setHasFixedSize(true)
        rv.layoutManager = llm
        rv.adapter = adapter
        adapter.setOnItemClickListener(object : RecyclerViewAdapter.onItemClickListener {
            override fun onGroupItemClick(item: GroupItem) {
                DataModel.pushScreen(item.name)
                resetScreen()
            }

            override fun onApplicationItemClick(item: ApplicationItem) {
                startActivity(DataModel.getAppIntent(item.packageName))
            }

            override fun onInformationItemClick(item: InformationItem) {

            }
        })

        val returnButton = findViewById<Button>(R.id.return_button)
        returnButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                backOperation()
            }
        })
        returnButton.visibility = if (titleName == null) View.GONE else View.VISIBLE

        val dividerItemDecoration = DividerItemDecoration(
            rv.getContext(),
            llm.orientation
        )
        rv.addItemDecoration(dividerItemDecoration)
        dividerItemDecoration.setDrawable(getDrawable(R.drawable.divider));
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        return if (keyCode == KeyEvent.KEYCODE_BACK) {
            backOperation()
            true
        } else false
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun backOperation() {
        DataModel.popScreen() // 現在のスクリーンは破棄
        resetScreen()
    }
}
