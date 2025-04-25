package com.example.cartelera.presentation.tv

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.example.cartelera.R
import com.example.cartelera.data.model.tv.TvShow
import com.example.cartelera.databinding.ActivityMovieBinding
import com.example.cartelera.databinding.ActivityTvShowBinding
import com.example.cartelera.presentation.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvShowActivity : BaseActivity() {

    val viewModel: TvShowViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val adapter = TvShowAdapter(ArrayList<TvShow>())
        with(binding as ActivityTvShowBinding) {
            recycler.adapter = adapter
            recycler.layoutManager = LinearLayoutManager(this@TvShowActivity)
        }

        viewModel.tvShows.observe(this) {
            adapter.tvShows.clear()
            adapter.tvShows.addAll(it)
            adapter.notifyDataSetChanged()
        }
    }

    override fun initBinding(): ViewBinding {
        return ActivityTvShowBinding.inflate(layoutInflater)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                with(binding as ActivityTvShowBinding) {
                    progressBar.visibility = View.VISIBLE
                    viewModel.updateTvShows()
                    progressBar.visibility = View.GONE
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}