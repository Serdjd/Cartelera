package com.example.cartelera.data.repository.movie.datasourceimpl

import com.example.cartelera.data.model.movie.detail.MovieCredits
import com.example.cartelera.data.model.movie.detail.MovieDetails
import com.example.cartelera.data.remote.api.TMDBService
import com.example.cartelera.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(
    private val tmdbService: TMDBService
) : MovieRemoteDataSource {
    override suspend fun getDetails(id: Int): Response<MovieDetails> {
        return tmdbService.getMovieDetails(id)
    }

    override suspend fun getCast(id: Int): Response<MovieCredits> {
        return tmdbService.getMovieCredits(id)
    }
}