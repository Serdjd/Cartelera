package com.example.cartelera.data.repository.artist.datasource

import com.example.cartelera.data.model.artist.Artist

interface ArtistLocalDataSource {
    suspend fun getArtistsFromDB(): List<Artist>
    suspend fun saveArtistsToDb(artists: List<Artist>)
    suspend fun clearAll()
}