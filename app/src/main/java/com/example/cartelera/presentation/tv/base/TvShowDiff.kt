package com.example.cartelera.presentation.tv.base

import androidx.recyclerview.widget.DiffUtil
import com.example.cartelera.data.model.tv.TvShow
import javax.inject.Inject

class TvShowDiff @Inject constructor() : DiffUtil.ItemCallback<TvShow>() {
    override fun areItemsTheSame(
        oldItem: TvShow,
        newItem: TvShow
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: TvShow,
        newItem: TvShow
    ): Boolean {
        return oldItem == newItem
    }

}
