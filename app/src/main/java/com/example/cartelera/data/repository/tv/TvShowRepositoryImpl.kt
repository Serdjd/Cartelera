package com.example.cartelera.data.repository.tv

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.cartelera.data.model.tv.TvShow
import com.example.cartelera.data.paging.TvShowPagingSource
import com.example.cartelera.domain.repository.TvShowRepository
import com.example.cartelera.presentation.tv.base.TvShowAdapter
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TvShowRepositoryImpl @Inject constructor(
    private val adapter: TvShowAdapter,
    private val paging: TvShowPagingSource
) : TvShowRepository {
    override fun getTvShows(): Flow<PagingData<TvShow>> {
        return Pager(
            PagingConfig(pageSize = 20),
            pagingSourceFactory = { paging }
        ).flow
    }

    override suspend fun updateTvShows() {
        adapter.refresh()
    }

}