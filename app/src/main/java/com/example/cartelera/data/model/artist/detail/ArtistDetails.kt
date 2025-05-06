package com.example.cartelera.data.model.artist.detail

import com.google.gson.annotations.SerializedName

data class ArtistDetails(
    @SerializedName("biography")
    val biography: String,
    @SerializedName("birthday")
    val birthday: String?,
    @SerializedName("deathday")
    val deathday: String?,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("place_of_birth")
    val placeOfBirth: String,
    @SerializedName("profile_path")
    val profilePath: String
)