package com.example.cartelera.presentation.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cartelera.data.model.movie.Movie
import com.example.cartelera.data.model.tv.TvShow
import com.example.cartelera.domain.usecase.GetMoviesUseCase
import com.example.cartelera.domain.usecase.GetTvShowsUseCase
import com.example.cartelera.domain.usecase.UpdateMoviesUseCase
import com.example.cartelera.domain.usecase.UpdateTvShowsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvShowViewModel @Inject constructor(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
): ViewModel() {

    private val _tvShows = MutableLiveData<List<TvShow>>()
    val tvShows: LiveData<List<TvShow>> get() = _tvShows

    init {
        getTvShows()
    }

    private fun getTvShows() {
        viewModelScope.launch {
            _tvShows.value = getTvShowsUseCase.execute()
        }
    }

    fun updateTvShows() {
        viewModelScope.launch {
            _tvShows.value = updateTvShowsUseCase.execute()
        }
    }
}