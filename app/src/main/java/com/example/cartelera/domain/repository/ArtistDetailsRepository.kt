package com.example.cartelera.domain.repository

import com.example.cartelera.data.model.artist.detail.ArtistDetails

interface ArtistDetailsRepository {
    suspend fun getDetails(id: Int): ArtistDetails?
}