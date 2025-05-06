package com.example.cartelera.presentation.tv.detail.series

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cartelera.data.util.load
import com.example.cartelera.databinding.ActivitySeriesDetailsBinding
import com.example.cartelera.presentation.BaseActivity
import com.example.cartelera.presentation.tv.detail.modal.Dialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SeriesActivity: BaseActivity() {

    val viewModel: SeriesViewModel by viewModels()

    private lateinit var binding: ActivitySeriesDetailsBinding
    private val adapter = ChapterAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySeriesDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        viewModel.fetchSeries(intent.getIntExtra("id",1))

        initView()
        initList()
        initToolbar()
    }

    fun initView() {
        binding.seasonBtn.setOnClickListener {
            val dialog = Dialog()
            dialog.show(supportFragmentManager, Dialog.TAG)
        }
        viewModel.series.observe(this) {
            if (it == null) return@observe

            with(binding) {
                name.text = it.name
                if (it.backdropPath != null) banner.load(it.backdropPath)
                year.text = it.firstAirDate
                val numberOfSeasons = it.numberOfSeasons.toString() +
                    if (it.numberOfSeasons > 1) " Seasons"
                    else " Season"
                this.numberOfSeasons.text = numberOfSeasons
                status.text = it.status
                overview.text = it.overview
            }
        }

        viewModel.actualSeason.observe(this) {
            binding.actualSeason.text = it.second
        }
    }

    fun initList() {
        binding.chapters.adapter = adapter
        binding.chapters.layoutManager = LinearLayoutManager(this)
        binding.chapters.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )

        viewModel.chapters.observe(this) {
            adapter.asyncListDiffer.submitList(it)
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