package com.example.rickandmortyapp.model.data.network

import com.example.rickandmortyapp.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val characterService: CharacterService by lazy {
        retrofit.create(CharacterService::class.java)
    }
}