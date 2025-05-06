package com.example.cartelera.domain.usecase.tv

import com.example.cartelera.domain.repository.SeriesRepository
import javax.inject.Inject

class GetSeasonChaptersUseCase @Inject constructor(
    private val seriesRepository: SeriesRepository
) {
    suspend fun execute(id: Int, seasonNumber: Int) = seriesRepository.getSeasonChapters(id,seasonNumber)
}