package com.example.cartelera.data.repository.artist.datasourceimpl

import com.example.cartelera.data.db.dao.ArtistDao
import com.example.cartelera.data.model.artist.Artist
import com.example.cartelera.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ArtistLocalDataSourceImpl @Inject constructor(
    private val artistDao: ArtistDao
): ArtistLocalDataSource {
    override suspend fun getArtistsFromDB(): List<Artist> {
        return artistDao.getArtists()
    }

    override suspend fun saveArtistsToDb(Artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtists(Artists)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteArtists()
        }
    }
}