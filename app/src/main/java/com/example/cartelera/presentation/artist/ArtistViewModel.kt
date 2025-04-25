package com.example.cartelera.presentation.artist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cartelera.data.model.artist.Artist
import com.example.cartelera.domain.usecase.GetArtistsUseCase
import com.example.cartelera.domain.usecase.UpdateArtistsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArtistViewModel @Inject constructor(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
) : ViewModel() {

    private val _artists = MutableLiveData<List<Artist>>()
    val artists: LiveData<List<Artist>> get() = _artists

    init {
        getArtists()
    }

    private fun getArtists() {
        viewModelScope.launch {
            _artists.value = getArtistsUseCase.execute()
        }
    }

    fun updateArtists() {
        viewModelScope.launch {
            _artists.value = updateArtistsUseCase.execute()
        }
    }
}