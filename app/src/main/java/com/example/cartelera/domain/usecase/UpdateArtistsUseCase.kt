package com.example.cartelera.domain.usecase

import com.example.cartelera.domain.repository.ArtistRepository
import javax.inject.Inject

class UpdateArtistsUseCase @Inject constructor(
    val repository: ArtistRepository
) {
    suspend fun execute() = repository.updateArtists()
}