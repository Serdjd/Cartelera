package com.example.cartelera.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.cartelera.data.model.movie.Movie
import com.example.cartelera.data.remote.api.TMDBService
import okio.IOException
import javax.inject.Inject

class MoviesPagingSource @Inject constructor(
    private val api: TMDBService
) : PagingSource<Int, Movie>() {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val page = params.key ?: 1
            val response = api.getPopularMovies(page = page).body()

            if (response == null) return LoadResult.Error(Exception("Null response"))

            val prevKey = if (page > 0) page - 1 else null
            val nextKey = if (response.totalPages > page) page + 1 else null
            LoadResult.Page(data = response.movies, prevKey = prevKey,  nextKey = nextKey)
        } catch (e: IOException) {
            LoadResult.Error(e)
        }
    }

}