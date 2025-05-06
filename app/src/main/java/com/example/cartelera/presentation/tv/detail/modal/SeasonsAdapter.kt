package com.example.cartelera.presentation.tv.detail.modal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cartelera.databinding.SeasonItemBinding

class SeasonsAdapter (val onClick: (Int) -> Unit): RecyclerView.Adapter<SeasonsAdapter.ViewHolder>() {

    private val diffUtil = object : DiffUtil.ItemCallback<Pair<Int, String>>() {
        override fun areItemsTheSame(
            oldItem: Pair<Int, String>,
            newItem: Pair<Int, String>
        ): Boolean {
            return oldItem.first == newItem.first
        }

        override fun areContentsTheSame(
            oldItem: Pair<Int, String>,
            newItem: Pair<Int, String>
        ): Boolean {
            return oldItem == newItem
        }
    }

    val asyncListDiffer = AsyncListDiffer(this,diffUtil)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = SeasonItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
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

    inner class ViewHolder (val binding: SeasonItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(season: Pair<Int, String>) {
            with(binding) {
                val text = "Season ${season.first} - ${season.second}"
                seasonNumber.text = text
                seasonNumber.setOnClickListener {
                    onClick.invoke(season.first)
                }
            }
        }
    }
}