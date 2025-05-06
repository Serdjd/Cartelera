package com.example.cartelera.presentation.tv.detail.series

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cartelera.data.model.tv.detail.SeriesDetails
import com.example.cartelera.data.model.tv.detail.chapter.Chapter
import com.example.cartelera.domain.usecase.tv.GetSeasonChaptersUseCase
import com.example.cartelera.domain.usecase.tv.GetSeriesDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SeriesViewModel @Inject constructor(
    private val getSeriesDetailsUseCase: GetSeriesDetailsUseCase,
    private val getSeasonChaptersUseCase: GetSeasonChaptersUseCase
): ViewModel() {

    private val _series = MutableLiveData<SeriesDetails>()
    val series: LiveData<SeriesDetails> get() = _series

    private val _actualSeason = MutableLiveData<Pair<Int, String>>()
    val actualSeason: LiveData<Pair<Int, String>> get() = _actualSeason

    private val _seasons = MutableLiveData<List<Pair<Int, String>>>()
    val seasons: LiveData<List<Pair<Int, String>>> get() = _seasons

    private val _chapters = MutableLiveData<List<Chapter>>()
    val chapters: LiveData<List<Chapter>> get() = _chapters

    fun changeActualSeason(seasonNumber: Int) {
        val name = _seasons.value?.find { it.first == seasonNumber }?.second
        if (name != null) _actualSeason.postValue(seasonNumber to name)
        viewModelScope.launch {
            val id = _series.value?.id
            if (id != null) fetchSeason(id,seasonNumber)
        }
    }

    fun fetchSeries(id: Int) {
        viewModelScope.launch {
            _series.postValue(getSeriesDetailsUseCase.execute(id))
            fetchSeason(id,_actualSeason.value?.first ?: 1)
            val list = _series.value?.seasons?.map { it.seasonNumber to "Season ${it.seasonNumber}" }?.toList()
            if (list != null) _seasons.postValue(list)
        }
    }

    private suspend fun fetchSeason(id: Int, seasonNumber: Int) = withContext(Dispatchers.IO) {
        _chapters.postValue(getSeasonChaptersUseCase.execute(id,seasonNumber))
    }
}