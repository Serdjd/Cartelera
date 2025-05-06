package com.example.cartelera.domain.repository

import androidx.paging.PagingData
import com.example.cartelera.data.model.movie.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getMovies(): Flow<PagingData<Movie>>
    suspend fun updateMovies()
}