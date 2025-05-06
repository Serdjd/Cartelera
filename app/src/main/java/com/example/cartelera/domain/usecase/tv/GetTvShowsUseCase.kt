package com.example.cartelera.domain.usecase.tv

import com.example.cartelera.domain.repository.TvShowRepository
import javax.inject.Inject

class GetTvShowsUseCase @Inject constructor(
    val repository: TvShowRepository
) {
    fun execute() = repository.getTvShows()
}