package com.example.coronastats.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
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
        binding.overviewRecyclerview.adapter = CoronaDataAdapter(CoronaDataAdapter.OnClickListener {
            viewModel.displayCountryDetails(it)
        })
        viewModel.navigateToSelectedCountry.observe(viewLifecycleOwner, Observer {
            if (null != it) {
                this.findNavController().navigate(
                    OverviewFragmentDirections.actionOverviewFragmentToDetailFragment(it))
                viewModel.displayCountryDetailsComplete()
            }
        })

        return binding.root
    }
}