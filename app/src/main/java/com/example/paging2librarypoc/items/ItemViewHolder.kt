package com.example.paging2librarypoc.items

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.paging2librarypoc.R
import com.example.paging2librarypoc.data.Item

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val itemNameTextView: TextView = itemView.findViewById(R.id.itemNameTextView)

    fun bind(item: Item) {
        itemNameTextView.text = item.name
    }
}
