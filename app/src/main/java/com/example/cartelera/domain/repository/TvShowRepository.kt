package com.example.cartelera.domain.repository

import com.example.cartelera.data.model.tv.TvShow

interface TvShowRepository {
    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows(): List<TvShow>?
}