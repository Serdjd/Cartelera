package com.example.cartelera.presentation.movie.base

import androidx.recyclerview.widget.DiffUtil
import com.example.cartelera.data.model.movie.Movie
import javax.inject.Inject

class MovieDiff @Inject constructor(): DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(
        oldItem: Movie,
        newItem: Movie
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: Movie,
        newItem: Movie
    ): Boolean {
        return oldItem == newItem
    }
}