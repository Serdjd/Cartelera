package com.example.cartelera.data.repository.movie

import com.example.cartelera.data.model.movie.detail.MovieCredits
import com.example.cartelera.data.model.movie.detail.MovieDetails
import com.example.cartelera.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.cartelera.domain.repository.MovieDetailRepository
import javax.inject.Inject

class MovieDetailsRepositoryImpl @Inject constructor(
    private val movieRemoteDataSource: MovieRemoteDataSource
): MovieDetailRepository {
    override suspend fun getDetails(id: Int): MovieDetails? {
        try {
            val body = movieRemoteDataSource.getDetails(id).body()
            if (body != null) {
                return body
            }
            return null
        } catch (e: Exception) {
            return null
        }
    }

    override suspend fun getCast(id: Int): MovieCredits? {
        try {
            val body = movieRemoteDataSource.getCast(id).body()

            if (body != null) {
                return body
            }
            return null
        } catch (e: Exception) {
            return null
        }
    }
}