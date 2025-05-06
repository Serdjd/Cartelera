package com.example.cartelera.domain.repository

import androidx.paging.PagingData
import com.example.cartelera.data.model.artist.Artist
import kotlinx.coroutines.flow.Flow

interface ArtistRepository {
    fun getArtists(): Flow<PagingData<Artist>>
    suspend fun updateArtists()
}