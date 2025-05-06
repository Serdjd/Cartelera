package com.example.cartelera.presentation

import android.os.Bundle
import android.view.View
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
    abstract fun initRoot(): View
    abstract fun initMain(): View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ViewCompat.setOnApplyWindowInsetsListener(initMain()) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        enableEdgeToEdge()
        setContentView(initRoot())
    }

    fun initToolbar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }
}