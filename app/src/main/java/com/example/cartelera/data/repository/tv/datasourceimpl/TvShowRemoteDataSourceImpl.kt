package com.example.cartelera.data.repository.tv.datasourceimpl

import com.example.cartelera.BuildConfig
import com.example.cartelera.data.api.TMDBService
import com.example.cartelera.data.model.tv.TvShowList
import com.example.cartelera.data.repository.tv.datasource.TvShowRemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class TvShowRemoteDataSourceImpl @Inject constructor(
    private val tmdbService: TMDBService
): TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList> {
        return tmdbService.getPopularTvShows(BuildConfig.API_KEY)
    }
}