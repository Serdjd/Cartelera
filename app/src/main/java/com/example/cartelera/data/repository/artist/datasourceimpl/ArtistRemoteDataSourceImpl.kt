package com.example.cartelera.data.repository.artist.datasourceimpl

import com.example.cartelera.BuildConfig
import com.example.cartelera.data.model.artist.detail.ArtistDetails
import com.example.cartelera.data.remote.api.TMDBService
import com.example.cartelera.data.model.artist.ArtistList
import com.example.cartelera.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class ArtistRemoteDataSourceImpl @Inject constructor(
    private val tmdbService: TMDBService
): ArtistRemoteDataSource {
    override suspend fun getArtists(page: Int): Response<ArtistList> {
        return tmdbService.getPopularArtist(page = page)
    }

    override suspend fun getArtistDetails(id: Int): Response<ArtistDetails> {
        return tmdbService.getArtistDetails(id)
    }
}