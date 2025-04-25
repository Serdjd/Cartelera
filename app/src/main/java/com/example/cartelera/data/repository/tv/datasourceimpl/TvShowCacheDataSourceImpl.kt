package com.example.cartelera.data.repository.tv.datasourceimpl

import com.example.cartelera.data.model.tv.TvShow
import com.example.cartelera.data.repository.tv.datasource.TvShowCacheDataSource
import javax.inject.Inject

class TvShowCacheDataSourceImpl @Inject constructor(): TvShowCacheDataSource {

    private var tvShowsList = arrayListOf<TvShow>()

    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowsList
    }

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowsList.clear()
        tvShowsList.addAll(tvShows)
    }
}