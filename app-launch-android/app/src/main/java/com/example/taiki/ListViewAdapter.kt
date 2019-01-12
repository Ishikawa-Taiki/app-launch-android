package com.example.taiki

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View

// TODO: データ引き渡しの構造と責務が気持ち悪いので整理する
class ListViewAdapter(list: List<RowData>, appLinkInfo: AppLinkInfo): RecyclerView.Adapter<ListViewHolder>() {
    private val list = list
    private val appLinkInfo = appLinkInfo
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
        val title = list.get(position).title
        val detail = list.get(position).detail
        val image = detail?.let { appLinkInfo.getPackageInfo(it)?.icon }
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
        fun onItemClick(data: RowData)
    }
}
