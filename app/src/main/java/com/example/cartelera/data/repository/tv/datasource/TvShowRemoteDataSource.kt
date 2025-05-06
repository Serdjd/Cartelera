package com.example.cartelera.data.repository.tv.datasource

import com.example.cartelera.data.model.tv.TvShowList
import com.example.cartelera.data.model.tv.detail.SeriesDetails
import com.example.cartelera.data.model.tv.detail.chapter.Chapter
import com.example.cartelera.data.model.tv.detail.chapter.Season
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows(page: Int): Response<TvShowList>
    suspend fun getSeriesDetails(id: Int): Response<SeriesDetails>
    suspend fun getSeasonChapters(id: Int, seasonNumber: Int): Response<Season>
}