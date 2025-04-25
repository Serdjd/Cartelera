package com.example.cartelera.data.repository.tv.datasource

import com.example.cartelera.data.model.tv.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowsFromCache(): List<TvShow>
    suspend fun saveTvShowsToCache(tvShows:List<TvShow>)
}