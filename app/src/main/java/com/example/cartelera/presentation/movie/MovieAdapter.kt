package com.example.cartelera.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cartelera.data.model.movie.Movie
import com.example.cartelera.databinding.ListItemBinding

class MovieAdapter(val movies: ArrayList<Movie>): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
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
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.count()
    }


    inner class ViewHolder(private val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind (movie: Movie) {
            binding.title.text = movie.title
            binding.description.text = movie.overview
            val url = "https://image.tmdb.org/t/p/w500${movie.posterPath}"
            Glide.with(binding.image.context).load(url).into(binding.image)
        }
    }
}