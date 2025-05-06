package com.example.cartelera.presentation.artist.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cartelera.data.model.artist.detail.ArtistDetails
import com.example.cartelera.domain.usecase.artist.GetArtistDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArtistDetailsViewModel @Inject constructor(
    private val getArtistDetailsUseCase: GetArtistDetailsUseCase
): ViewModel() {
    private val _details = MutableLiveData<ArtistDetails>()
    val details: LiveData<ArtistDetails> get() = _details

    fun fetchDetails(id: Int) {
        viewModelScope.launch {
            _details.postValue(getArtistDetailsUseCase.execute(id))
        }
    }
}