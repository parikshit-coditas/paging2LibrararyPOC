package com.example.paging2librarypoc.pagingSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.paging2librarypoc.data.Item

class ItemPagingSource : PagingSource<Int, Item>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Item> {
        val page = params.key ?: 1
        val items = (1..200).map { Item(it, "Item $it") }
        return LoadResult.Page(
            data = items,
            prevKey = if (page == 1) null else page - 1,
            nextKey = if (items.isEmpty()) null else page + 1
        )
    }

    override fun getRefreshKey(state: PagingState<Int, Item>): Int? {
        return state.anchorPosition?.let { state.closestItemToPosition(it)?.id }
    }
}