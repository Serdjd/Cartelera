package com.example.cartelera.presentation.movie.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.cartelera.data.model.movie.Movie
import com.example.cartelera.domain.usecase.movie.GetMoviesUseCase
import com.example.cartelera.domain.usecase.movie.UpdateMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel

class MovieViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
): ViewModel() {

    private val _movies : Flow<PagingData<Movie>> = fetchMovies()
    val movies: Flow<PagingData<Movie>> get() = _movies


    private fun fetchMovies() = getMoviesUseCase.execute().cachedIn(viewModelScope)

    fun updateMovies() {
        viewModelScope.launch {
           updateMoviesUseCase.execute()
        }
    }
}