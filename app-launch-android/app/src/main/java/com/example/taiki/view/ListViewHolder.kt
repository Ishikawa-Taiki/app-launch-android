package com.example.taiki.view

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView
import android.widget.TextView;
import com.example.taiki.R

class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    public var titleView = itemView.findViewById(R.id.title) as TextView;
    public var detailView = itemView.findViewById(R.id.detail) as TextView;
    public var iconView = itemView.findViewById(R.id.icon) as ImageView
}