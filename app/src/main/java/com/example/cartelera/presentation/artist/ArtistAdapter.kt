package com.example.cartelera.presentation.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cartelera.data.model.artist.Artist
import com.example.cartelera.data.model.movie.Movie
import com.example.cartelera.databinding.ListItemBinding

class ArtistAdapter(val artists: ArrayList<Artist>): RecyclerView.Adapter<ArtistAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = ListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.bind(artists[position])
    }

    override fun getItemCount(): Int {
        return artists.count()
    }


    inner class ViewHolder(private val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind (artist: Artist) {
            binding.title.text = artist.name
            binding.description.text = artist.popularity.toString()
            val url = "https://image.tmdb.org/t/p/w500${artist.profilePath}"
            Glide.with(binding.image.context).load(url).into(binding.image)
        }
    }
}