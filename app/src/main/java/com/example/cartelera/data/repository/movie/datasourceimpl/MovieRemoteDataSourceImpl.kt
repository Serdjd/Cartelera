package com.example.cartelera.data.repository.movie.datasourceimpl

import com.example.cartelera.BuildConfig
import com.example.cartelera.data.api.TMDBService
import com.example.cartelera.data.model.movie.MovieList
import com.example.cartelera.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(
    private val tmdbService: TMDBService
): MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> {
        return tmdbService.getPopularMovies(BuildConfig.API_KEY)
    }
}