package com.example.cartelera.presentation.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cartelera.data.model.movie.Movie
import com.example.cartelera.domain.usecase.GetMoviesUseCase
import com.example.cartelera.domain.usecase.UpdateMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel

class MovieViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
): ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> get() = _movies

    init {
        getMovies()
    }

    private fun getMovies() {
        viewModelScope.launch {
            _movies.value = getMoviesUseCase.execute()
        }
    }

    fun updateMovies() {
        viewModelScope.launch {
            _movies.value = updateMoviesUseCase.execute()
        }
    }
}