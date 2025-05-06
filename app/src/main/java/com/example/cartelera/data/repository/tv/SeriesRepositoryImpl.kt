package com.example.cartelera.data.repository.tv

import com.example.cartelera.data.model.tv.detail.SeriesDetails
import com.example.cartelera.data.model.tv.detail.chapter.Chapter
import com.example.cartelera.data.repository.tv.datasource.TvShowRemoteDataSource
import com.example.cartelera.domain.repository.SeriesRepository
import javax.inject.Inject

class SeriesRepositoryImpl @Inject constructor(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource
) : SeriesRepository {
    override suspend fun getSeriesDetails(id: Int): SeriesDetails? {
        return try {
            tvShowRemoteDataSource.getSeriesDetails(id).body()
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun getSeasonChapters(
        id: Int,
        seasonNumber: Int
    ): List<Chapter>? {
        return try {
            tvShowRemoteDataSource.getSeasonChapters(id,seasonNumber).body()?.chapters
        } catch (e: Exception) {
            null
        }
    }
}