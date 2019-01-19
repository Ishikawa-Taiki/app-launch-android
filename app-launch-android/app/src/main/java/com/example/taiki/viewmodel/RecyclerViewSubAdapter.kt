package com.example.taiki.viewmodel

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View
import com.example.taiki.R
import com.example.taiki.model.*
import com.example.taiki.view.RecyclerViewSubHolder

class RecyclerViewSubAdapter(titleName: String): RecyclerView.Adapter<RecyclerViewSubHolder>() {

    private val list = DataModel.getItemList(titleName)

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
        var targetItem = list.get(position)
        if (targetItem is ApplicationItem) {
            holder.titleView.setText(targetItem.appName)
            val image = targetItem.packageName?.let { DataModel.getAppIcon(it) }
            image?.let { holder.iconView.setImageDrawable(image) }
        }
        if (targetItem is InformationItem) {
            holder.titleView.setText(targetItem.text)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        this.listener = listener
    }

    interface onItemClickListener {
        fun onItemClick(item: Item)
    }
}
