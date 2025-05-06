package com.example.cartelera.presentation.tv.base

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cartelera.R
import com.example.cartelera.databinding.ActivityTvShowBinding
import com.example.cartelera.presentation.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class TvShowActivity : BaseActivity() {

    val viewModel: TvShowViewModel by viewModels()
    @Inject lateinit var adapter: TvShowAdapter

    private lateinit var binding: ActivityTvShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityTvShowBinding.inflate(layoutInflater)
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
            viewModel.tvShows.collectLatest {
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
                    viewModel.updateTvShows()
                    progressBar.visibility = View.GONE
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}