package com.example.cartelera.data.repository.artist

import android.util.Log
import com.example.cartelera.data.model.artist.Artist
import com.example.cartelera.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.cartelera.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.cartelera.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.cartelera.domain.repository.ArtistRepository
import javax.inject.Inject

class ArtistRepositoryImpl @Inject constructor(
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource,
    private val artistRemoteDataSource: ArtistRemoteDataSource
) : ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val artists = getArtistsFromApi()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDb(artists)
        artistCacheDataSource.saveArtistsToCache(artists)
        return artists
    }

    suspend fun getArtistsFromApi(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            if (body != null) {
                artistList = body.artists
            }
        } catch (e: Exception) {
            Log.i("INFO", e.message.toString())
        }
        return artistList
    }

    suspend fun getArtistsFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistsFromDB()
        } catch (e: Exception) {
            Log.i("INFO", e.message.toString())
        }
        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistsFromApi()
            artistLocalDataSource.saveArtistsToDb(artistList)
        }
        return artistList
    }

    suspend fun getArtistsFromCache(): List<Artist> {
        var artistList = artistCacheDataSource.getArtistsFromCache()
        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistsFromDB()
            artistCacheDataSource.saveArtistsToCache(artistList)
        }
        return artistList
    }
}