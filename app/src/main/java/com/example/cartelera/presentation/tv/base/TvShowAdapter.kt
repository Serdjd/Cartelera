package com.example.cartelera.presentation.tv.base

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cartelera.data.model.tv.TvShow
import com.example.cartelera.data.util.load
import com.example.cartelera.databinding.ListItemBinding
import com.example.cartelera.presentation.tv.detail.series.SeriesActivity
import javax.inject.Inject

class TvShowAdapter @Inject constructor(diff: TvShowDiff): PagingDataAdapter<TvShow,TvShowAdapter.ViewHolder>(diff) {
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
        val tvShow = getItem(position)
        if(tvShow != null) holder.bind(tvShow)
    }

    override fun onViewRecycled(holder: ViewHolder) {
        super.onViewRecycled(holder)
        holder.clear()
    }

    inner class ViewHolder(private val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind (tvShow: TvShow) {
            binding.title.text = tvShow.name
            binding.description.text = tvShow.overview
            binding.image.load(tvShow.posterPath.toString())
            binding.card.setOnClickListener {
                val context = binding.root.context
                val intent = Intent(context, SeriesActivity::class.java)
                intent.putExtra("id",tvShow.id)
                context.startActivity(intent)
            }
        }

        fun clear() {
            val image = binding.image
            Glide.with(image.context).clear(image)
        }
    }
}