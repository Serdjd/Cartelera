package com.example.cartelera.domain.repository

import com.example.cartelera.data.model.movie.detail.MovieCredits
import com.example.cartelera.data.model.movie.detail.MovieDetails

interface MovieDetailRepository {
    suspend fun getDetails(id: Int): MovieDetails?
    suspend fun getCast(id: Int): MovieCredits?
}