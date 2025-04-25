package com.example.cartelera.data.repository.tv.datasource

import com.example.cartelera.data.model.tv.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows(): Response<TvShowList>
}