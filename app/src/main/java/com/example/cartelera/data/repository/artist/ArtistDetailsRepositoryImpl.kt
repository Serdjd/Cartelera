package com.example.cartelera.data.repository.artist

import com.example.cartelera.data.model.artist.detail.ArtistDetails
import com.example.cartelera.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.cartelera.domain.repository.ArtistDetailsRepository
import javax.inject.Inject

class ArtistDetailsRepositoryImpl @Inject constructor(
    private val artistRemoteDataSource: ArtistRemoteDataSource
) : ArtistDetailsRepository {
    override suspend fun getDetails(id: Int): ArtistDetails? {
        return try {
            artistRemoteDataSource.getArtistDetails(id).body()
        } catch (e: Exception) {
            null
        }
    }
}