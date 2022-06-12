package com.example.rickandmortyapp.model.data.network

import com.example.rickandmortyapp.entities.Character
import com.example.rickandmortyapp.entities.Result
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterService {

    @GET("character")
    suspend fun getCharacters(@Query("page") pageNum: Int): Response<Character>

    @GET("character/{num}")
    suspend fun getCharacter(@Path("num") num: Int): Response<Result>
}