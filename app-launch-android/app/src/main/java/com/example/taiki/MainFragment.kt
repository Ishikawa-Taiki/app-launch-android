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
import com.example.taiki.viewmodel.ScreenStack


class MainFragment : Fragment() {

    private var screen = ScreenStack();

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState != null) {
            screen = savedInstanceState.getSerializable("screen") as ScreenStack ?: ScreenStack();
        }
        refreshScreen()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable("screen", screen)
    }

    private fun refreshScreen() {
        val titleName = screen.peekScreen()
        activity!!.setTitle(titleName ?: getString(R.string.app_name))

        val adapter = RecyclerViewAdapter(DataModel.getFilterItemList(titleName ?: "root"))
        val rv = activity!!.findViewById(R.id.listView) as RecyclerView
        val llm = LinearLayoutManager(getContext())
        rv.setHasFixedSize(true)
        rv.layoutManager = llm
        rv.adapter = adapter
        adapter.setOnItemClickListener(object : RecyclerViewAdapter.onItemClickListener {
            override fun onGroupItemClick(item: GroupItem) {
                screen.pushScreen(item.name)
                refreshScreen()
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
        adapter.setOnItemLongClickListener(object : RecyclerViewAdapter.onItemLongClickListener {
            override fun onApplicationItemLongClick(item: ApplicationItem): Boolean {
                return DataModel.copyText(item.appName+"="+item.packageName);
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
                    refreshScreen()
                }
            }
        )
    }

    private fun backOperation() {
        val currentScreen = screen.popScreen() // 現在のスクリーンは破棄

        if (currentScreen != null) {
            refreshScreen()
        } else {
            // TODO: 考える
//            finish()
        }
    }
}