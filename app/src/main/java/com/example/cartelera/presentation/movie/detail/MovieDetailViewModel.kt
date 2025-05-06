package com.example.cartelera.presentation.movie.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cartelera.data.model.movie.detail.MovieCredits
import com.example.cartelera.data.model.movie.detail.MovieDetails
import com.example.cartelera.domain.usecase.movie.GetCastUseCase
import com.example.cartelera.domain.usecase.movie.GetMovieDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase,
    private val getCastUseCase: GetCastUseCase
): ViewModel(){
    private val _details = MutableLiveData<MovieDetails>()
    val details: LiveData<MovieDetails> get() = _details

    private val _cast = MutableLiveData<MovieCredits>()
    val cast: LiveData<MovieCredits> get() = _cast

    fun getDetails(id: Int) {
        viewModelScope.launch {
            val details = async { getMovieDetailsUseCase.execute(id) }
            val cast = async { getCastUseCase.execute(id) }

            _details.postValue(details.await())
            _cast.postValue(cast.await())
        }
    }
}