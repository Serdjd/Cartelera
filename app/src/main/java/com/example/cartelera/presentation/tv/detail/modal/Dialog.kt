package com.example.cartelera.presentation.tv.detail.modal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cartelera.R
import com.example.cartelera.databinding.DialogBinding
import com.example.cartelera.presentation.tv.detail.series.SeriesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue

@AndroidEntryPoint
class Dialog: DialogFragment() {

    private val viewModel: SeriesViewModel by activityViewModels()
    lateinit var adapter: SeasonsAdapter

    private lateinit var binding: DialogBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL,R.style.Base_Theme_Cartelera)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = SeasonsAdapter {
            viewModel.changeActualSeason(it)
            dismiss()
        }

        binding.seasons.adapter = adapter
        binding.seasons.layoutManager = LinearLayoutManager(requireContext())
        binding.seasons.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                LinearLayoutManager.VERTICAL
            )
        )
        viewModel.seasons.observe(viewLifecycleOwner) {
            adapter.asyncListDiffer.submitList(it)
        }
    }

    companion object {
        const val TAG = "ModalBottomSheet"
    }
}