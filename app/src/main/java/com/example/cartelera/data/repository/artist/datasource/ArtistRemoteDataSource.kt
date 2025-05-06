package com.example.cartelera.data.repository.artist.datasource

import com.example.cartelera.data.model.artist.detail.ArtistDetails
import com.example.cartelera.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(page: Int): Response<ArtistList>
    suspend fun getArtistDetails(id: Int): Response<ArtistDetails>
}