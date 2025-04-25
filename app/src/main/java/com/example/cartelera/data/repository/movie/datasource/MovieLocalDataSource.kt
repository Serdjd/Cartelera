package com.example.cartelera.data.repository.movie.datasource

import com.example.cartelera.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMoviesToDb(movies:List<Movie>)
    suspend fun clearAll()
}