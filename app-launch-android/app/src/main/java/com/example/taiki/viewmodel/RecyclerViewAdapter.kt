package com.example.taiki.viewmodel

import android.graphics.Color
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View
import com.example.taiki.R
import com.example.taiki.model.*
import com.example.taiki.view.RecyclerViewHolder

class RecyclerViewAdapter(list:List<Item>) : RecyclerView.Adapter<RecyclerViewHolder>() {

    private val list = list

    private var listener: onItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        val holder = RecyclerViewHolder(inflate)
        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val index = holder.adapterPosition
                list.get(index)?.let {
                    if (it is GroupItem) {
                        listener?.onGroupItemClick(it)
                    }
                    if (it is ApplicationItem) {
                        listener?.onApplicationItemClick(it)
                    }
                    if (it is TitleTextItem) {
                        listener?.onTitleTextItemClick(it)
                    }
                    if (it is TextItem) {
                        listener?.onTextItemClick(it)
                    }
                    if (it is LinkItem) {
                        listener?.onLinkItemClick(it)
                    }
                }
            }
        })
        return holder
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        var targetItem = list.get(position)
        if (targetItem is GroupItem) {
            holder.itemContainer.setBackgroundColor(Color.WHITE)
            holder.titleView.setText(targetItem.name)
            holder.titleView.setTextColor(Color.BLACK)

            holder.iconView.setImageResource(R.drawable.ic_home_black_24dp)
            holder.iconView.visibility = View.VISIBLE
            holder.iconSpace.visibility = View.GONE
        }
        if (targetItem is ApplicationItem) {
            holder.itemContainer.setBackgroundColor(Color.WHITE)
            holder.titleView.setText(targetItem.appName)
            holder.titleView.setTextColor(Color.BLACK)

            val appIcon = DataModel.getAppIcon(targetItem.packageName)
            if (appIcon != null) {
                holder.iconView.setImageDrawable(appIcon)
            } else {
                holder.iconView.setImageResource(R.mipmap.ic_launcher)
            }
            holder.iconView.visibility = View.VISIBLE
            holder.iconSpace.visibility = View.GONE
        }
        if (targetItem is TitleTextItem) {
            holder.itemContainer.setBackgroundColor(Color.DKGRAY)
            holder.titleView.setText(targetItem.text)
            holder.titleView.setTextColor(Color.WHITE)

            holder.iconView.visibility = View.GONE
            holder.iconSpace.visibility = View.GONE
        }
        if (targetItem is TextItem) {
            holder.itemContainer.setBackgroundColor(Color.LTGRAY)
            holder.titleView.setText(targetItem.text)
            holder.titleView.setTextColor(Color.BLACK)

            holder.iconView.visibility = View.GONE
            holder.iconSpace.visibility = View.VISIBLE
        }
        if (targetItem is LinkItem) {
            holder.itemContainer.setBackgroundColor(Color.WHITE)
            holder.titleView.setText(targetItem.url)
            holder.titleView.setTextColor(Color.BLUE)

            holder.iconView.visibility = View.GONE
            holder.iconSpace.visibility = View.VISIBLE
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        this.listener = listener
    }

    interface onItemClickListener {
        fun onGroupItemClick(item: GroupItem)
        fun onApplicationItemClick(item: ApplicationItem)
        fun onTitleTextItemClick(item: TitleTextItem)
        fun onTextItemClick(item: TextItem)
        fun onLinkItemClick(item: LinkItem)
    }
}
