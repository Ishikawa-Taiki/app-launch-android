package com.example.taiki.view

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView
import android.widget.TextView;
import com.example.taiki.R

class RecyclerViewMainHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    var titleView = itemView.findViewById(R.id.title) as TextView;
    var iconView = itemView.findViewById(R.id.icon) as ImageView
}
