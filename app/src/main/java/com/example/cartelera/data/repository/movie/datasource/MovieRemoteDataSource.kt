package com.example.cartelera.data.repository.movie.datasource

import com.example.cartelera.data.model.movie.detail.MovieCredits
import com.example.cartelera.data.model.movie.detail.MovieDetails
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getDetails(id: Int): Response<MovieDetails>
    suspend fun getCast(id: Int): Response<MovieCredits>
}