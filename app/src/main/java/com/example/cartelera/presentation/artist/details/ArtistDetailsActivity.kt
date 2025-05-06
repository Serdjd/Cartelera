package com.example.cartelera.presentation.artist.details

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import com.example.cartelera.data.util.load
import com.example.cartelera.databinding.ActivityArtistDetailsBinding
import com.example.cartelera.presentation.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class ArtistDetailsActivity: BaseActivity() {

    private val viewModel: ArtistDetailsViewModel by viewModels()

    private lateinit var binding: ActivityArtistDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityArtistDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        val id = intent.getIntExtra("id",1)
        viewModel.fetchDetails(id)
        initToolbar()
        initView()
    }

    fun initView() {
        viewModel.details.observe(this) {
            with(binding) {
                photo.load(it.profilePath)
                name.text = it.name
                if (it.birthday != null) {
                    var dates = "(${it.birthday}"
                    if (it.deathday != null) dates += " / ${it.deathday}"
                    dates += ")"
                    this.dates.text = dates
                }
                biography.text = it.biography
            }
        }
    }

    override fun initRoot(): View {
        return binding.root
    }

    override fun initMain(): View {
        return binding.main
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressedDispatcher.onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}