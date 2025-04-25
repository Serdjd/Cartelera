package com.example.cartelera.data.repository.tv.datasourceimpl

import com.example.cartelera.data.db.dao.TvShowDao
import com.example.cartelera.data.model.tv.TvShow
import com.example.cartelera.data.repository.tv.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class TvShowLocalDataSourceImpl @Inject constructor(
    private val tvShowDao: TvShowDao
): TvShowLocalDataSource {
    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return tvShowDao.getTvShows()
    }

    override suspend fun saveTvShowsToDb(TvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShow(TvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteTvShows()
        }
    }
}