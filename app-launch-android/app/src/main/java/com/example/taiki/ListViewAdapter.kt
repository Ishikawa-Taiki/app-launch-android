package com.example.taiki

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View

class ListViewAdapter(list: List<RowData>): RecyclerView.Adapter<ListViewHolder>() {
    private val list = list
    private var listener: onItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.list_row, parent, false)
        val holder = ListViewHolder(inflate)
        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                listener?.onItemClick(list.get(holder.adapterPosition))
            }
        })
        return holder
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.titleView.setText(list.get(position).title)
        holder.detailView.setText(list.get(position).detail)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        this.listener = listener
    }

    interface onItemClickListener {
        fun onItemClick(data: RowData)
    }
}
