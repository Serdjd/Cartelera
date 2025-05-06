package com.example.cartelera.presentation.movie.detail

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.cartelera.R
import com.example.cartelera.data.util.load
import com.example.cartelera.databinding.ActivityMovieDetailsBinding
import com.example.cartelera.presentation.BaseActivity
import com.google.android.material.chip.Chip
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MovieDetailsActivity: BaseActivity() {

    val viewModel: MovieDetailViewModel by viewModels()
    @Inject lateinit var adapter: MovieCastAdapter

    private lateinit var binding: ActivityMovieDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)

        viewModel.getDetails(intent.getIntExtra("id",1))

        initToolbar()
        initView()
        initList()
    }

    override fun initRoot(): View {
        return binding.root
    }

    override fun initMain(): View {
        return binding.main
    }

    fun initView() {
        viewModel.details.observe(this) {
            with(binding) {
                title.text = it.title
                banner.load(it.backdropPath)
                poster.load(it.posterPath)
                for (tag in it.genres) {
                    val chip = layoutInflater.inflate(R.layout.chip, tags,false) as Chip
                    chip.text = tag.name
                    tags.addView(chip)
                }

                val date = "Release Date: ${it.releaseDate}"
                release.text = date

                val average = (it.voteAverage * 10).toInt()
                this.average.text = "${average} %"
                tomato.setImageResource(
                    if (average >= 50) R.drawable.tomate
                    else R.drawable.tomate_pocho
                )

                val popularity = (it.popularity).toInt()
                this.popularity.text = popularity.toString()
                palom.setImageResource(
                    if (popularity >= 50) R.drawable.palomitas
                    else R.drawable.palomitas_pocho
                )
            }
        }
    }

    fun initList() {
        binding.artists.adapter = adapter
        val layout = LinearLayoutManager(this)
        layout.orientation = LinearLayoutManager.HORIZONTAL
        binding.artists.layoutManager = layout

        viewModel.cast.observe(this) {
            if (it != null) {
                adapter.asyncListDiffer.submitList(it.cast)
            }

        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressedDispatcher.onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}