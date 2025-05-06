package com.example.cartelera.domain.repository

import com.example.cartelera.data.model.tv.detail.SeriesDetails
import com.example.cartelera.data.model.tv.detail.chapter.Chapter

interface SeriesRepository {
    suspend fun getSeriesDetails(id: Int): SeriesDetails?
    suspend fun getSeasonChapters(id: Int, seasonNumber: Int): List<Chapter>?
}