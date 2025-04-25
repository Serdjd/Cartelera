package com.example.cartelera.data.repository.tv.datasource

import com.example.cartelera.data.model.tv.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowsFromDB(): List<TvShow>
    suspend fun saveTvShowsToDb(tvShows: List<TvShow>)
    suspend fun clearAll()
}