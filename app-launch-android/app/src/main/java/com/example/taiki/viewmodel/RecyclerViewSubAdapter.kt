package com.example.taiki.viewmodel

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View
import com.example.taiki.R
import com.example.taiki.model.ApplicationData
import com.example.taiki.model.DataModel
import com.example.taiki.view.RecyclerViewSubHolder

class RecyclerViewSubAdapter(titleName: String): RecyclerView.Adapter<RecyclerViewSubHolder>() {
    private val appList = DataModel.getApplicationList()
    private val list = DataModel.getUseCaseList().filter { it.titleName == titleName && it.appName.isNotEmpty() }.map {
        val targetName = it.appName
        appList.find { it.appName == targetName }
    }

    private var listener: onItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewSubHolder {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.item_row_sub, parent, false)
        val holder = RecyclerViewSubHolder(inflate)
        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                list.get(holder.adapterPosition)?.let { listener?.onItemClick(it) }
            }
        })
        return holder
    }

    override fun onBindViewHolder(holder: RecyclerViewSubHolder, position: Int) {
        val title = list.get(position)?.appName
        val image = list.get(position)?.packageName?.let { DataModel.getAppIcon(it) }
        holder.titleView.setText(title)
        image?.let { holder.iconView.setImageDrawable(image) }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        this.listener = listener
    }

    interface onItemClickListener {
        fun onItemClick(data: ApplicationData)
    }
}
