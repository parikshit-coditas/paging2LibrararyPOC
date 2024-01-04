package com.example.paging2librarypoc.screens.homeScreen

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.paging2librarypoc.databinding.ActivityMainBinding
import com.example.paging2librarypoc.pagingSource.ItemAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val adapter = ItemAdapter()
        binding.recyclerView.adapter = adapter

        lifecycleScope.launch {
            viewModel.items.collectLatest {
                adapter.submitData(it)
            }
        }
    }
}

