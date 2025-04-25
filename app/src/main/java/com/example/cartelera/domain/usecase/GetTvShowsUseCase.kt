package com.example.cartelera.domain.usecase

import com.example.cartelera.domain.repository.TvShowRepository
import javax.inject.Inject

class GetTvShowsUseCase @Inject constructor(
    val repository: TvShowRepository
) {
    suspend fun execute() = repository.getTvShows()
}