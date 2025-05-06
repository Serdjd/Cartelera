package com.example.cartelera.data.util


import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.cartelera.R

fun ImageView.load(path: String, width: Int = 500) {
    Glide
        .with(this.context)
        .applyDefaultRequestOptions(
            RequestOptions()
                .error(R.drawable.default_profile)
        )
        .load("https://image.tmdb.org/t/p/w${width}$path")
        .into(this)
}

fun ImageView.loadDefault() {
    Glide
        .with(this.context)
        .load(R.drawable.baseline_image_not_supported_24)
        .into(this)
}