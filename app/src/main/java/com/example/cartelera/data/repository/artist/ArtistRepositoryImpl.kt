package com.example.cartelera.data.repository.artist

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.cartelera.data.model.artist.Artist
import com.example.cartelera.data.paging.ArtistPagingSource
import com.example.cartelera.domain.repository.ArtistRepository
import com.example.cartelera.presentation.artist.base.ArtistAdapter
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ArtistRepositoryImpl @Inject constructor(
    private val adapter: ArtistAdapter,
    private val paging: ArtistPagingSource
) : ArtistRepository {
    override fun getArtists(): Flow<PagingData<Artist>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { paging }
        ).flow
    }

    override suspend fun updateArtists() {
        adapter.refresh()
    }

}