package com.example.cartelera.domain.usecase.movie

import com.example.cartelera.domain.repository.MovieRepository
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    val repository: MovieRepository
) {
    fun execute() = repository.getMovies()
}