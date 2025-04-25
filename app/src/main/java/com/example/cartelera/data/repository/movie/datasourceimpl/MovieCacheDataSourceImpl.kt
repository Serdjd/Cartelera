package com.example.cartelera.data.repository.movie.datasourceimpl

import com.example.cartelera.data.model.movie.Movie
import com.example.cartelera.data.repository.movie.datasource.MovieCacheDataSource
import javax.inject.Inject

class MovieCacheDataSourceImpl @Inject constructor(): MovieCacheDataSource {

    private var moviesList = arrayListOf<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return moviesList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        moviesList.clear()
        moviesList.addAll(movies)
    }
}