package com.example.cartelera.presentation.movie.detail

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cartelera.data.model.movie.detail.Cast
import com.example.cartelera.data.util.load
import com.example.cartelera.databinding.ArtistCardBinding
import com.example.cartelera.presentation.artist.details.ArtistDetailsActivity
import javax.inject.Inject

class MovieCastAdapter @Inject constructor(): RecyclerView.Adapter<MovieCastAdapter.ViewHolder>() {

    private val diffUtil = object : DiffUtil.ItemCallback<Cast>() {
        override fun areItemsTheSame(
            oldItem: Cast,
            newItem: Cast
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Cast,
            newItem: Cast
        ): Boolean {
            return oldItem == newItem
        }
    }

    val asyncListDiffer = AsyncListDiffer(this,diffUtil)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = ArtistCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.bind(
            asyncListDiffer.currentList[position]
        )
    }

    override fun getItemCount(): Int {
        return asyncListDiffer.currentList.count()
    }

    override fun onViewRecycled(holder: ViewHolder) {
        super.onViewRecycled(holder)
        holder.clear()
    }

    inner class ViewHolder(val binding: ArtistCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cast: Cast) {
            with(binding) {
                photo.load(cast.profilePath.toString())
                realName.text = cast.name
                characterName.text = cast.character
                card.setOnClickListener {
                    val context = binding.root.context
                    val intent = Intent(context, ArtistDetailsActivity::class.java)
                    intent.putExtra("id",cast.id)
                    context.startActivity(intent)
                }
            }
        }

        fun clear() {
            val image = binding.photo
            Glide.with(image.context).clear(image)
        }
    }
}