package com.example.cartelera.data.repository.tv.datasourceimpl

import com.example.cartelera.data.model.tv.TvShowList
import com.example.cartelera.data.model.tv.detail.SeriesDetails
import com.example.cartelera.data.model.tv.detail.chapter.Season
import com.example.cartelera.data.remote.api.TMDBService
import com.example.cartelera.data.repository.tv.datasource.TvShowRemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class TvShowRemoteDataSourceImpl @Inject constructor(
    private val tmdbService: TMDBService
) : TvShowRemoteDataSource {
    override suspend fun getTvShows(page: Int): Response<TvShowList> {
        return tmdbService.getPopularTvShows(page = page)
    }

    override suspend fun getSeriesDetails(id: Int): Response<SeriesDetails> {
        return tmdbService.getSeriesDetails(id)
    }

    override suspend fun getSeasonChapters(
        id: Int,
        seasonNumber: Int
    ): Response<Season> {
        return tmdbService.getSeasonChapters(id = id, seasonNumber = seasonNumber)
    }
}