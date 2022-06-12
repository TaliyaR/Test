package com.example.rickandmortyapp.model.data.network

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickandmortyapp.entities.Result
import retrofit2.HttpException

class CharacterPagingSource(
    private val characterService: CharacterService
) : PagingSource<Int, Result>() {

    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        val page = params.key ?: 1

        val response = characterService.getCharacters(page)
        if (response.isSuccessful) {
            val charactersResponse = response.body()
            val data = charactersResponse?.results

            var nextPage: Int? = null
            if (charactersResponse?.info?.next != null) {
                val uri = Uri.parse(charactersResponse.info.next)
                val nextPageQuery = uri.getQueryParameter("page")
                nextPage = nextPageQuery?.toInt()
            }

            var prevPage: Int? = null
            if (charactersResponse?.info?.prev != null) {
                val uri = Uri.parse(charactersResponse.info.next)
                val prevPageQuery = uri.getQueryParameter("page")
                prevPage = prevPageQuery?.toInt()
            }
            return LoadResult.Page(data.orEmpty(), prevPage, nextPage)

        } else {
            return LoadResult.Error(HttpException(response))
        }
    }

}