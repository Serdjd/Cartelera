package com.example.cartelera.presentation.movie.base

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.core.view.ViewCompat
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.example.cartelera.R
import com.example.cartelera.databinding.ActivityMovieBinding
import com.example.cartelera.presentation.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MovieActivity : BaseActivity() {

    val viewmodel: MovieViewModel by viewModels()
    @Inject lateinit var adapter: MovieAdapter

    private lateinit var binding: ActivityMovieBinding

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMovieBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        val layoutManager = object : LinearLayoutManager(this) {
            var isScrollEnabled = true

            override fun canScrollVertically(): Boolean {
                return isScrollEnabled && super.canScrollVertically()
            }
        }
        with(binding) {
            recycler.adapter = adapter

            recycler.layoutManager = layoutManager
        }

        lifecycleScope.launch {
            viewmodel.movies.collectLatest {
                adapter.submitData(it)
            }
            adapter.loadStateFlow.collectLatest {
                val state = (it.refresh is LoadState.Loading || it.append is LoadState.Loading)
                layoutManager.isScrollEnabled = !state
                if (state) binding.progressBar.visibility = View.VISIBLE
                else binding.progressBar.visibility = View.GONE
            }
        }

    }

    override fun initRoot(): View {
        return binding.root
    }

    override fun initMain(): View {
        return binding.main
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                with(binding) {
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