package com.example.taiki

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.taiki.model.*
import com.example.taiki.viewmodel.RecyclerViewAdapter
import com.example.taiki.viewmodel.ScreenStack


class InstalledAppsFragment : Fragment() {

    private var screen = ScreenStack();

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.installed_apps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState != null) {
            screen = savedInstanceState.getSerializable("installedAppsScreen") as ScreenStack ?: ScreenStack();
        }
        refreshScreen()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable("installedAppsScreen", screen)
    }

    private fun refreshScreen() {
        val titleName = screen.peekScreen()

        val adapter = RecyclerViewAdapter(DataModel.getInstalledItemList())
        val rv = activity!!.findViewById(R.id.installedAppsList) as RecyclerView
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

        val dividerItemDecoration = DividerItemDecoration(
            rv.getContext(),
            llm.orientation
        )
        rv.addItemDecoration(dividerItemDecoration)
        dividerItemDecoration.setDrawable(activity!!.getDrawable(R.drawable.divider));
    }
}