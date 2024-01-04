package com.example.paging2librarypoc.pagingSource

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.example.paging2librarypoc.R
import com.example.paging2librarypoc.data.Item
import com.example.paging2librarypoc.items.ItemDiffCallback
import com.example.paging2librarypoc.items.ItemViewHolder

class ItemAdapter : PagingDataAdapter<Item, ItemViewHolder>(ItemDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item)
        }
    }
}

