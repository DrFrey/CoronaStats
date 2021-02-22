package com.example.coronastats.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.coronastats.databinding.FragmentOverviewBinding

class OverviewFragment: Fragment() {
    private val viewModel: OverviewViewmodel by lazy {
        ViewModelProvider(this).get(OverviewViewmodel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOverviewBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.overviewRecyclerview.adapter = CoronaDataAdapter()
        return binding.root
    }
}