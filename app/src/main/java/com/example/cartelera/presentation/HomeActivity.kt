package com.example.cartelera.presentation

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.cartelera.databinding.ActivityMainBinding
import com.example.cartelera.presentation.artist.base.ArtistActivity
import com.example.cartelera.presentation.movie.base.MovieActivity
import com.example.cartelera.presentation.tv.base.TvShowActivity

class HomeActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setListeners()
    }

    override fun initRoot(): View {
        return binding.root
    }

    override fun initMain(): View {
        return binding.main
    }

    fun setListeners() {
        with(binding) {
            movie.setOnClickListener {
                val intent = Intent(this@HomeActivity, MovieActivity::class.java)
                startActivity(intent)
            }
            tvShow.setOnClickListener {
                val intent = Intent(this@HomeActivity, TvShowActivity::class.java)
                startActivity(intent)
            }
            artist.setOnClickListener {
                val intent = Intent(this@HomeActivity, ArtistActivity::class.java)
                startActivity(intent)
            }
        }
    }
}