package com.example.cartelera.presentation.artist.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.cartelera.data.model.artist.Artist
import com.example.cartelera.domain.usecase.artist.GetArtistsUseCase
import com.example.cartelera.domain.usecase.artist.UpdateArtistsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArtistViewModel @Inject constructor(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
) : ViewModel() {

    private val _artists: Flow<PagingData<Artist>> = fetchArtists()
    val artists: Flow<PagingData<Artist>> get() = _artists

    private fun fetchArtists() = getArtistsUseCase.execute().cachedIn(viewModelScope)

    fun updateArtists() {
        viewModelScope.launch {
            updateArtistsUseCase.execute()
        }
    }
}