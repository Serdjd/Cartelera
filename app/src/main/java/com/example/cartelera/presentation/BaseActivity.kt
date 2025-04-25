package com.example.cartelera.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewbinding.ViewBinding
import com.example.cartelera.databinding.ActivityArtistBinding
import com.example.cartelera.databinding.ActivityMainBinding
import com.example.cartelera.databinding.ActivityMovieBinding
import com.example.cartelera.databinding.ActivityTvShowBinding

abstract class BaseActivity: AppCompatActivity() {

    protected lateinit var binding: ViewBinding

    abstract fun initBinding(): ViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = initBinding()

        super.onCreate(savedInstanceState)

        val main = when(binding) {
            is ActivityMainBinding -> {
                (binding as ActivityMainBinding).main
            }
            is ActivityMovieBinding -> {
                (binding as ActivityMovieBinding).main
            }
            is ActivityTvShowBinding -> (binding as ActivityTvShowBinding).main
            is ActivityArtistBinding -> (binding as ActivityArtistBinding).main
            else -> null
        }

        main?.let {
            ViewCompat.setOnApplyWindowInsetsListener(it) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }

        enableEdgeToEdge()

        setContentView(binding.root)
    }
}