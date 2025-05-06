package com.example.cartelera.domain.repository

import androidx.paging.PagingData
import com.example.cartelera.data.model.tv.TvShow
import kotlinx.coroutines.flow.Flow

interface TvShowRepository {
    fun getTvShows(): Flow<PagingData<TvShow>>
    suspend fun updateTvShows()
}