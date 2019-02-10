package com.example.taiki

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import com.example.taiki.viewmodel.RecyclerViewAdapter
import android.support.v7.widget.DividerItemDecoration
import android.view.KeyEvent
import com.example.taiki.model.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataModel.init(applicationContext)
        resetScreen()
    }

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

            override fun onTitleTextItemClick(item: TitleTextItem) {
            }

            override fun onTextItemClick(item: TextItem) {
            }

            override fun onLinkItemClick(item: LinkItem) {
                startActivity(DataModel.getLinkIntent(item.url))
            }
        })

        val returnButton = findViewById<Button>(R.id.return_button)
        returnButton.visibility = View.VISIBLE
        if (titleName == null) {
            returnButton.text = "再読み込み"
            returnButton.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View) {
                    rebuild()
                }
            })
        } else {
            returnButton.text = "戻る"
            returnButton.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View) {
                    backOperation()
                }
            })
        }

        val dividerItemDecoration = DividerItemDecoration(
            rv.getContext(),
            llm.orientation
        )
        rv.addItemDecoration(dividerItemDecoration)
        dividerItemDecoration.setDrawable(getDrawable(R.drawable.divider));
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        return if (keyCode == KeyEvent.KEYCODE_BACK) {
            backOperation()
            true
        } else false
    }

    private fun backOperation() {
        val currentScreen = DataModel.popScreen() // 現在のスクリーンは破棄

        if (currentScreen != null) {
            resetScreen()
        } else {
            finish()
        }
    }

    private fun rebuild() {
        DataModel.refreshSaveData(
            {
                if (it) {
                    resetScreen()
                }
            }
        )
    }
}
