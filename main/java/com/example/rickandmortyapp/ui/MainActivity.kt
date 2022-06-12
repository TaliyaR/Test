package com.example.rickandmortyapp.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.presenter.MainViewModel
import com.example.rickandmortyapp.ui.rv.CharacterAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private var recyclerAdapter = CharacterAdapter {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_items.layoutManager = GridLayoutManager(this, 2)
        rv_items.adapter = recyclerAdapter

        lifecycleScope.launch {
            viewModel.characters.collectLatest {
                recyclerAdapter.submitData(it)
            }
        }
    }
}