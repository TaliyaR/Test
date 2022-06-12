package com.example.rickandmortyapp.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.rickandmortyapp.entities.Result
import com.example.rickandmortyapp.model.data.network.ApiFactory
import com.example.rickandmortyapp.model.data.network.CharacterPagingSource
import com.example.rickandmortyapp.model.data.network.CharacterService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MainViewModel constructor(
    private val service: CharacterService = ApiFactory.characterService
) : ViewModel() {

    val characters: Flow<PagingData<Result>> = Pager(PagingConfig(20)) {
        CharacterPagingSource(service)
    }.flow.cachedIn(viewModelScope)
}