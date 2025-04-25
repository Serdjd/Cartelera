package com.example.cartelera.presentation.tv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cartelera.data.model.movie.Movie
import com.example.cartelera.data.model.tv.TvShow
import com.example.cartelera.databinding.ListItemBinding

class TvShowAdapter(val tvShows: ArrayList<TvShow>): RecyclerView.Adapter<TvShowAdapter.ViewHolder>() {
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
        holder.bind(tvShows[position])
    }

    override fun getItemCount(): Int {
        return tvShows.count()
    }


    inner class ViewHolder(private val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind (tvShow: TvShow) {
            binding.title.text = tvShow.name
            binding.description.text = tvShow.overview
            val url = "https://image.tmdb.org/t/p/w500${tvShow.posterPath}"
            Glide.with(binding.image.context).load(url).into(binding.image)
        }
    }
}