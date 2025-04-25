package com.example.cartelera.presentation.artist

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.example.cartelera.R
import com.example.cartelera.data.model.artist.Artist
import com.example.cartelera.databinding.ActivityArtistBinding
import com.example.cartelera.databinding.ActivityTvShowBinding
import com.example.cartelera.presentation.BaseActivity
import com.example.cartelera.presentation.tv.TvShowActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArtistActivity : BaseActivity() {

    val viewModel: ArtistViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val adapter = ArtistAdapter(ArrayList<Artist>())
        with(binding as ActivityArtistBinding) {
            recycler.adapter = adapter
            recycler.layoutManager = LinearLayoutManager(this@ArtistActivity)
        }

        viewModel.artists.observe(this) {
            adapter.artists.clear()
            adapter.artists.addAll(it)
            adapter.notifyDataSetChanged()
        }
    }

    override fun initBinding(): ViewBinding {
        return ActivityArtistBinding.inflate(layoutInflater)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                with(binding as ActivityArtistBinding) {
                    progressBar.visibility = View.VISIBLE
                    viewModel.updateArtists()
                    progressBar.visibility = View.GONE
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}