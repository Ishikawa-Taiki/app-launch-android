package com.example.taiki

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

class ListViewAdapter(list: List<RowData>): RecyclerView.Adapter<ListViewHolder>() {
    private val list = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.list_row, parent, false)
        return ListViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.titleView.setText(list.get(position).title)
        holder.detailView.setText(list.get(position).detail)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
