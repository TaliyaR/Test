package com.example.rickandmortyapp.model.repository

import com.example.rickandmortyapp.model.data.network.ApiFactory
import com.example.rickandmortyapp.model.data.network.CharacterService

class CharacterRepository(
    private val service: CharacterService = ApiFactory.characterService
) {

    suspend fun getCharacterList(pageNum: Int) = service.getCharacters(pageNum)
}