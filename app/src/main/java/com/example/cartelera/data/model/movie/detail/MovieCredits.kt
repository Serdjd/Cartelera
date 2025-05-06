package com.example.cartelera.data.model.movie.detail


import com.google.gson.annotations.SerializedName

data class MovieCredits(
    @SerializedName("cast")
    val cast: List<Cast>,
    @SerializedName("id")
    val id: Int
)