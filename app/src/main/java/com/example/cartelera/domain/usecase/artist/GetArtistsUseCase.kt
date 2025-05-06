package com.example.cartelera.domain.usecase.artist

import com.example.cartelera.domain.repository.ArtistRepository
import javax.inject.Inject

class GetArtistsUseCase @Inject constructor(
    val repository: ArtistRepository
) {
    fun execute() = repository.getArtists()
}