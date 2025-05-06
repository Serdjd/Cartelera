package com.example.cartelera.domain.usecase.tv

import com.example.cartelera.domain.repository.TvShowRepository
import javax.inject.Inject

class UpdateTvShowsUseCase @Inject constructor(
    val repository: TvShowRepository
) {
    suspend fun execute() = repository.updateTvShows()
}