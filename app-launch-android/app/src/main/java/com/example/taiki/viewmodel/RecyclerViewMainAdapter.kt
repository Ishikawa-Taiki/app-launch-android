package com.example.taiki.viewmodel

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View
import com.example.taiki.R
import com.example.taiki.model.ApplicationData
import com.example.taiki.model.DataModel
import com.example.taiki.view.RecyclerViewMainHolder

class RecyclerViewMainAdapter: RecyclerView.Adapter<RecyclerViewMainHolder>() {
    private val list = DataModel.getApplicationList()
    private var listener: onItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewMainHolder {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.item_row_main, parent, false)
        val holder = RecyclerViewMainHolder(inflate)
        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                listener?.onItemClick(list.get(holder.adapterPosition))
            }
        })
        return holder
    }

    override fun onBindViewHolder(holder: RecyclerViewMainHolder, position: Int) {
        val title = list.get(position).appName
        val detail = list.get(position).packageName
        val image = detail?.let { DataModel.getAppIcon(it) }
        holder.titleView.setText(title)
        holder.detailView.setText(detail)
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