package com.example.cartelera.presentation.tv.detail.series

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cartelera.data.model.tv.detail.chapter.Chapter
import com.example.cartelera.data.util.load
import com.example.cartelera.data.util.loadDefault
import com.example.cartelera.databinding.ChapterItemBinding

class ChapterAdapter : RecyclerView.Adapter<ChapterAdapter.ViewHolder>() {

    private val diffUtil = object : DiffUtil.ItemCallback<Chapter>() {
        override fun areItemsTheSame(
            oldItem: Chapter,
            newItem: Chapter
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Chapter,
            newItem: Chapter
        ): Boolean {
            return oldItem == newItem
        }
    }

    val asyncListDiffer = AsyncListDiffer(this,diffUtil)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = ChapterItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.bind(asyncListDiffer.currentList[position])
    }

    override fun getItemCount(): Int {
        return asyncListDiffer.currentList.count()
    }

    inner class ViewHolder (val binding: ChapterItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(chapter: Chapter) {
            with(binding) {
                if (chapter.stillPath != null) {
                    preview.load(chapter.stillPath,300)
                } else preview.loadDefault()
                name.text = chapter.name
                val info = "Episode ${chapter.episodeNumber}\t${chapter.runtime} min"
                this.info.text = info
            }
        }
    }
}