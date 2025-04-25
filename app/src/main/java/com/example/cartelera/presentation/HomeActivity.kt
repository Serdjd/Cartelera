package com.example.cartelera.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewbinding.ViewBinding
import com.example.cartelera.R
import com.example.cartelera.databinding.ActivityMainBinding
import com.example.cartelera.presentation.artist.ArtistActivity
import com.example.cartelera.presentation.movie.MovieActivity
import com.example.cartelera.presentation.tv.TvShowActivity

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setListeners()
    }

    override fun initBinding(): ViewBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    fun setListeners() {
        with(binding as ActivityMainBinding) {
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