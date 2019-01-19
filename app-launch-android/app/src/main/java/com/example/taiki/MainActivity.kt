package com.example.taiki

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import com.example.taiki.viewmodel.RecyclerViewSubAdapter
import android.support.v7.widget.DividerItemDecoration
import android.view.KeyEvent
import com.example.taiki.model.*
import java.util.*


class MainActivity : AppCompatActivity() {

    var stack = Stack<String>()

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataModel.init(applicationContext)
        setScreen()
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun setScreen(titleName: String? = null) {
        setContentView(R.layout.activity_sub)

        val adapter = RecyclerViewSubAdapter(titleName)
        val rv = findViewById(R.id.listView) as RecyclerView
        val llm = LinearLayoutManager(this)
        rv.setHasFixedSize(true)
        rv.layoutManager = llm
        rv.adapter = adapter
        adapter.setOnItemClickListener(object : RecyclerViewSubAdapter.onItemClickListener {
            override fun onItemClick(item: Item) {
                if (item is GroupItem) {
                    stack.push(item.name)
                    setScreen(item.name)
                }
                if (item is ApplicationItem) {
                    val targetPackageName = item.packageName
                    val intent =
                        DataModel.getAppIntent(targetPackageName) ?: DataModel.getStoreIntent(targetPackageName)
                    startActivity(intent)
                }
//                if (item is InformationItem) {
//                    stack.push(item.text)
//                }
            }
        })

        val returnButton = findViewById<Button>(R.id.return_button)
        returnButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                backOperation()
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
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        return if (keyCode == KeyEvent.KEYCODE_BACK) {
            backOperation()
            true
        } else false
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun backOperation() {
        try {
            stack.pop() // 現在のスクリーンは破棄
            setScreen(stack.peek())
        }
        catch (e: EmptyStackException){
            setScreen()
        }
    }
}
