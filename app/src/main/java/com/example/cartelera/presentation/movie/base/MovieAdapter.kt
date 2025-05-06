package com.example.cartelera.presentation.movie.base

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cartelera.data.model.movie.Movie
import com.example.cartelera.data.util.load
import com.example.cartelera.databinding.ListItemBinding
import com.example.cartelera.presentation.movie.detail.MovieDetailsActivity
import javax.inject.Inject

class MovieAdapter @Inject constructor(
    diff: MovieDiff
): PagingDataAdapter<Movie,MovieAdapter.ViewHolder>(
    diff
) {
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
        val movie = getItem(position)
        if (movie != null) holder.bind(movie)
    }

    override fun onViewRecycled(holder: ViewHolder) {
        super.onViewRecycled(holder)
        holder.clear()
    }


    inner class ViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind (movie: Movie) {
            binding.title.text = movie.title
            binding.description.text = movie.overview
            binding.image.load(movie.posterPath.toString())
            binding.card.setOnClickListener {
                val context = binding.root.context
                val intent = Intent(context, MovieDetailsActivity::class.java)
                intent.putExtra("id",movie.id)
                context.startActivity(intent)
            }
        }

        fun clear() {
            val image = binding.image
            Glide.with(image.context).clear(image)
        }
    }
}