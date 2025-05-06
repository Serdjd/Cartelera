package com.example.cartelera.domain.usecase.movie

import com.example.cartelera.domain.repository.MovieDetailRepository
import javax.inject.Inject

class GetCastUseCase @Inject constructor(
    private val movieDetailsRepository: MovieDetailRepository
) {
    suspend fun execute(id: Int) = movieDetailsRepository.getCast(id)
}