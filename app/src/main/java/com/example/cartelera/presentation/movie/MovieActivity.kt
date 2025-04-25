package com.example.cartelera.presentation.movie

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.example.cartelera.R
import com.example.cartelera.data.model.movie.Movie
import com.example.cartelera.databinding.ActivityMovieBinding
import com.example.cartelera.presentation.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieActivity : BaseActivity() {

    val viewmodel: MovieViewModel by viewModels()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val adapter = MovieAdapter(ArrayList<Movie>())
        with(binding as ActivityMovieBinding) {
            recycler.adapter = adapter
            recycler.layoutManager = LinearLayoutManager(this@MovieActivity)
        }
        viewmodel.movies.observe(this) {
            with(binding as ActivityMovieBinding) {
                adapter.movies.clear()
                adapter.movies.addAll(it)
                adapter.notifyDataSetChanged()
            }
        }
    }

    override fun initBinding(): ViewBinding {
        return ActivityMovieBinding.inflate(layoutInflater)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                with(binding as ActivityMovieBinding) {
                    progressBar.visibility = View.VISIBLE
                    viewmodel.updateMovies()
                    progressBar.visibility = View.GONE
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}