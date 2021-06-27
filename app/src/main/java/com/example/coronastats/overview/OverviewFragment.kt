package com.example.coronastats.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.coronastats.databinding.FragmentOverviewBinding

class OverviewFragment: Fragment(), CoronaDataAdapter.OnItemClickListener {
    private val viewModel: OverviewViewmodel by lazy {
        ViewModelProvider(this).get(OverviewViewmodel::class.java)
    }

    private lateinit var adapter: CoronaDataAdapter
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentOverviewBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        adapter = CoronaDataAdapter()
        adapter.setOnItemClickListener(this)
        binding.overviewRecyclerview.adapter = adapter

        viewModel.stats.observe(viewLifecycleOwner, {
            adapter.submitList(it)
            swipeRefreshLayout.isRefreshing = false
        })

        swipeRefreshLayout = binding.swipeRefreshLayout
        swipeRefreshLayout.setOnRefreshListener {
            viewModel.getCoronaStats()
        }

        return binding.root
    }

    override fun onItemClick(position: Int) {
        val countryData = adapter.currentList[position]
        this.findNavController().navigate(OverviewFragmentDirections.actionOverviewFragmentToDetailFragment(countryData))
    }
}