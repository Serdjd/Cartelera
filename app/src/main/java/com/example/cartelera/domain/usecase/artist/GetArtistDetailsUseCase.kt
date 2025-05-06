package com.example.cartelera.domain.usecase.artist

import com.example.cartelera.domain.repository.ArtistDetailsRepository
import javax.inject.Inject

class GetArtistDetailsUseCase @Inject constructor(
    private val artistDetailsRepository: ArtistDetailsRepository
) {
    suspend fun execute(id: Int) = artistDetailsRepository.getDetails(id)
}