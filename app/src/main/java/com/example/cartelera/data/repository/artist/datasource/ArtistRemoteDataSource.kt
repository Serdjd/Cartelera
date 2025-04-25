package com.example.cartelera.data.repository.artist.datasource

import com.example.cartelera.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>
}