package com.example.cartelera.presentation.artist.base

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cartelera.data.model.artist.Artist
import com.example.cartelera.data.util.load
import com.example.cartelera.databinding.ListItemBinding
import com.example.cartelera.presentation.artist.details.ArtistDetailsActivity
import javax.inject.Inject

class ArtistAdapter @Inject constructor(
    diff: ArtistDiff
): PagingDataAdapter<Artist,ArtistAdapter.ViewHolder>(
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
        val artist = getItem(position)
        if (artist != null)holder.bind(artist)
    }

    override fun onViewRecycled(holder: ViewHolder) {
        super.onViewRecycled(holder)
        holder.clear()
    }

    inner class ViewHolder(private val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind (artist: Artist) {
            binding.title.text = artist.name
            binding.description.text = artist.popularity.toString()
            binding.image.load(artist.profilePath.toString())
            binding.card.setOnClickListener {
                val context = binding.root.context
                val intent = Intent(context, ArtistDetailsActivity::class.java)
                intent.putExtra("id",artist.id)
                context.startActivity(intent)
            }
        }

        fun clear() {
            val image = binding.image
            Glide.with(image.context).clear(image)
        }
    }
}