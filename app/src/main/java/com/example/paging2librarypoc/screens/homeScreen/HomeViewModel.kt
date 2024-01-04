package com.example.paging2librarypoc.screens.homeScreen

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.paging2librarypoc.pagingSource.ItemPagingSource

class HomeViewModel : ViewModel() {
    val items = Pager(PagingConfig(pageSize = 10)) {
        ItemPagingSource()
    }.flow
}