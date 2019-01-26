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
import okhttp3.*
import java.io.IOException
import kotlin.concurrent.thread


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
        val titleName = DataModel.peekScreen()?.title
        setTitle(titleName ?: getString(R.string.app_name))

        val adapter = RecyclerViewAdapter()
        val rv = findViewById(R.id.listView) as RecyclerView
        val llm = LinearLayoutManager(this)
        rv.setHasFixedSize(true)
        rv.layoutManager = llm
        rv.adapter = adapter
        adapter.setOnItemClickListener(object : RecyclerViewAdapter.onItemClickListener {
            override fun onGroupItemClick(index: Int, item: GroupItem) {
                DataModel.pushScreen(ScreenInformation(index, item.name))
                resetScreen()
            }

            override fun onApplicationItemClick(index: Int, item: ApplicationItem) {
                startActivity(DataModel.getAppIntent(item.packageName))
            }

            override fun onInformationItemClick(index: Int, item: InformationItem) {
                item.linkURL?.let { startActivity(DataModel.getLinkIntent(it)) }
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
        val currentScreen = DataModel.popScreen() // 現在のスクリーンは破棄

        if (currentScreen != null) {
            resetScreen()
        } else {
            //finish()
            testRequest()
        }
    }

    private fun testRequest() {
        val url = "https://script.google.com/macros/s/AKfycbzLNP_CPag82-Aw7r7QF8lQ2Y8kwBGjOVv_3BlZFXlflkYp5Bo/exec?file=app&sheet=shopping"
        run(url)
    }

    private val client = OkHttpClient()

    @Throws(Exception::class)
    fun run(url: String) {
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                if (!response.isSuccessful) throw IOException("Unexpected code $response")

                val responseHeaders = response.headers()
                var i = 0
                val size = responseHeaders.size()
                while (i < size) {
                    println(responseHeaders.name(i) + ": " + responseHeaders.value(i))
                    i++
                }

                println(response.body()!!.string())
            }
        })
    }
}
