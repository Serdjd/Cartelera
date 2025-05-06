package com.example.cartelera.data.repository.movie

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.cartelera.data.model.movie.Movie
import com.example.cartelera.data.paging.MoviesPagingSource
import com.example.cartelera.domain.repository.MovieRepository
import com.example.cartelera.presentation.movie.base.MovieAdapter
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImplementation @Inject constructor(
    private val adapter: MovieAdapter,
    private val paging: MoviesPagingSource
): MovieRepository {

    override fun getMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { paging }
        ).flow
    }

    override suspend fun updateMovies() {
        adapter.refresh()
    }
}