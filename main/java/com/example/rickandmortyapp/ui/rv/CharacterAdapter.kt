package com.example.rickandmortyapp.ui.rv

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.rickandmortyapp.entities.Result

class CharacterAdapter(
    private var data: List<Result> = emptyList(),
    private val clickLambda: (Result) -> Unit
) : PagingDataAdapter<Result, CharacterViewHolder>(CharacterDiffItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder =
        CharacterViewHolder.create(parent, clickLambda)


    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

private object CharacterDiffItemCallback : DiffUtil.ItemCallback<Result>() {
    override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean =
        oldItem == newItem
}