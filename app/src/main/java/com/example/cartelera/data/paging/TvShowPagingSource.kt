package com.example.cartelera.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.cartelera.data.model.tv.TvShow
import com.example.cartelera.data.remote.api.TMDBService
import okio.IOException
import javax.inject.Inject

class TvShowPagingSource @Inject constructor(
    private val api: TMDBService
) : PagingSource<Int, TvShow>() {
    override fun getRefreshKey(state: PagingState<Int, TvShow>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TvShow> {
        return try {
            val page = params.key ?: 1
            val response = api.getPopularTvShows(page = page).body()

            if (response == null) return LoadResult.Error(Exception("Null response"))

            val prevKey = if (page > 0) page - 1 else null
            val nextKey = if(response.totalPages > page) page + 1 else null
            LoadResult.Page(data = response.tvShows, prevKey = prevKey, nextKey = nextKey)
        } catch (e: IOException) {
            return LoadResult.Error(e)
        }
    }
}