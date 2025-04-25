package com.example.cartelera.domain.usecase

import com.example.cartelera.domain.repository.MovieRepository
import javax.inject.Inject

class UpdateMoviesUseCase @Inject constructor(
    val repository: MovieRepository
) {
    suspend fun execute() = repository.updateMovies()
}