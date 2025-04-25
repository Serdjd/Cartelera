package com.example.cartelera.data.repository.artist.datasourceimpl

import com.example.cartelera.BuildConfig
import com.example.cartelera.data.api.TMDBService
import com.example.cartelera.data.model.artist.ArtistList
import com.example.cartelera.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class ArtistRemoteDataSourceImpl @Inject constructor(
    private val tmdbService: TMDBService
): ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> {
        return tmdbService.getPopularArtist(BuildConfig.API_KEY)
    }
}