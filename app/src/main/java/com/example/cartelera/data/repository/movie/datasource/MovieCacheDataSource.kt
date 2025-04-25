package com.example.cartelera.data.repository.movie.datasource

import com.example.cartelera.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movies:List<Movie>)
}