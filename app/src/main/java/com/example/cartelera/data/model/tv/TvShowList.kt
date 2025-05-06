package com.example.cartelera.data.model.tv


import com.google.gson.annotations.SerializedName

data class TvShowList(
    @SerializedName("results")
    val tvShows: List<TvShow>,
    @SerializedName("total_pages")
    val totalPages: Int
)