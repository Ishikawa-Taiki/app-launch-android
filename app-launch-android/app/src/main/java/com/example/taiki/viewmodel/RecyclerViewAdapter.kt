package com.example.taiki.viewmodel

import android.graphics.Color
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View
import com.example.taiki.R
import com.example.taiki.model.*
import com.example.taiki.view.RecyclerViewHolder

class RecyclerViewAdapter(titleName: String? = null): RecyclerView.Adapter<RecyclerViewHolder>() {

    private val list = titleName?.let { DataModel.getItemList(it)} ?: DataModel.getUseCaseList()

    private var listener: onItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        val holder = RecyclerViewHolder(inflate)
        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                list.get(holder.adapterPosition)?.let { listener?.onItemClick(it) }
            }
        })
        return holder
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        var targetItem = list.get(position)
        if (targetItem is GroupItem) {
            holder.titleView.setText(targetItem.name)
            holder.titleView.setTextColor(Color.BLUE)

            holder.iconView.setImageResource(R.drawable.ic_home_black_24dp)
            holder.iconView.visibility = View.VISIBLE
        }
        if (targetItem is ApplicationItem) {
            holder.titleView.setText(targetItem.appName)
            holder.titleView.setTextColor(Color.BLACK)

            val appIcon = DataModel.getAppIcon(targetItem.packageName)
            if (appIcon != null) {
                holder.iconView.setImageDrawable(appIcon)
            }
            else {
                holder.iconView.setImageResource(R.mipmap.ic_launcher)
            }
            holder.iconView.visibility = View.VISIBLE
        }
        if (targetItem is InformationItem) {
            holder.titleView.setText(targetItem.text)
            holder.titleView.setTextColor(Color.RED)

            holder.iconView.visibility = View.INVISIBLE
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