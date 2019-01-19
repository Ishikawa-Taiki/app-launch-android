package com.example.taiki

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import com.example.taiki.model.ApplicationData
import com.example.taiki.model.DataModel
import com.example.taiki.viewmodel.RecyclerViewMainAdapter
import com.example.taiki.viewmodel.RecyclerViewSubAdapter
import android.support.v7.widget.DividerItemDecoration
import android.view.KeyEvent
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    var isSubScreen = false

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataModel.init(applicationContext)
        setMainScreenMode()
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun setMainScreenMode() {
        isSubScreen = false
        setContentView(R.layout.activity_main)

        val adapter = RecyclerViewMainAdapter()
        val rv = findViewById(R.id.listView) as RecyclerView
        val llm = LinearLayoutManager(this)
        rv.setHasFixedSize(true)
        rv.layoutManager = llm
        rv.adapter = adapter
        adapter.setOnItemClickListener(object : RecyclerViewMainAdapter.onItemClickListener {
            override fun onItemClick(titleName: String) {
                setSubScreenMode(titleName)
            }
        })

        val dividerItemDecoration = DividerItemDecoration(
            rv.getContext(),
            llm.orientation
        )
        rv.addItemDecoration(dividerItemDecoration)
        dividerItemDecoration.setDrawable(getDrawable(R.drawable.divider));
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun setSubScreenMode(titleName: String) {
        isSubScreen = true
        setContentView(R.layout.activity_sub)

        val adapter = RecyclerViewSubAdapter(titleName)
        val rv = findViewById(R.id.listView) as RecyclerView
        val llm = LinearLayoutManager(this)
        rv.setHasFixedSize(true)
        rv.layoutManager = llm
        rv.adapter = adapter
        adapter.setOnItemClickListener(object : RecyclerViewSubAdapter.onItemClickListener {
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

        val memoText = findViewById<TextView>(R.id.memo)
        memoText.setText(DataModel.getInformation(titleName))

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
            if (isSubScreen) {
                setMainScreenMode()
            }
            true
        } else false
    }
}
