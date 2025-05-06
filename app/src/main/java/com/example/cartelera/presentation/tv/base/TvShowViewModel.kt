package com.example.cartelera.presentation.tv.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.cartelera.data.model.tv.TvShow
import com.example.cartelera.domain.usecase.tv.GetTvShowsUseCase
import com.example.cartelera.domain.usecase.tv.UpdateTvShowsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvShowViewModel @Inject constructor(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModel() {

    private val _tvShows = fetchTvShows()
    val tvShows: Flow<PagingData<TvShow>> get() = _tvShows


    private fun fetchTvShows() = getTvShowsUseCase.execute().cachedIn(viewModelScope)

    fun updateTvShows() {
        viewModelScope.launch {
            updateTvShowsUseCase.execute()
        }
    }
}