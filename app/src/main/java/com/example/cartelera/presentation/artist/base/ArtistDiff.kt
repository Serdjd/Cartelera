package com.example.cartelera.presentation.artist.base

import androidx.recyclerview.widget.DiffUtil
import com.example.cartelera.data.model.artist.Artist
import javax.inject.Inject

class ArtistDiff @Inject constructor(): DiffUtil.ItemCallback<Artist>() {
    override fun areItemsTheSame(
        oldItem: Artist,
        newItem: Artist
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: Artist,
        newItem: Artist
    ): Boolean {
        return oldItem == newItem
    }
}