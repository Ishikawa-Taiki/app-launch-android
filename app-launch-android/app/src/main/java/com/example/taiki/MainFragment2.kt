package com.example.taiki

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.taiki.model.*
import com.example.taiki.viewmodel.RecyclerViewAdapter


class MainFragment2 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        resetScreen()
    }

    private fun resetScreen() {
        val titleName = DataModel.peekScreen()
        activity!!.setTitle(titleName ?: getString(R.string.app_name))

        val adapter = RecyclerViewAdapter()
        val rv = activity!!.findViewById(R.id.listView) as RecyclerView
        val llm = LinearLayoutManager(getContext())
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

        val returnButton = activity!!.findViewById<Button>(R.id.return_button)
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
        dividerItemDecoration.setDrawable(activity!!.getDrawable(R.drawable.divider));
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

    private fun backOperation() {
        val currentScreen = DataModel.popScreen() // 現在のスクリーンは破棄

        if (currentScreen != null) {
            resetScreen()
        } else {
            // TODO: 考える
//            finish()
        }
    }
}