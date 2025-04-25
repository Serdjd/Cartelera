package com.example.cartelera.data.repository.movie.datasource

import com.example.cartelera.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}