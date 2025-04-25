package com.example.cartelera.data.repository.artist.datasourceimpl

import com.example.cartelera.data.model.artist.Artist
import com.example.cartelera.data.repository.artist.datasource.ArtistCacheDataSource
import javax.inject.Inject

class ArtistCacheDataSourceImpl @Inject constructor(): ArtistCacheDataSource {

    private var artistsList = arrayListOf<Artist>()

    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistsList
    }

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistsList.clear()
        artistsList.addAll(artists)
    }
}