package com.example.coronastats.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.coronastats.databinding.FragmentDetailBinding

class DetailFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(activity).application
        val binding = FragmentDetailBinding.inflate(inflater)
        val countryData = DetailFragmentArgs.fromBundle(requireArguments()).selectedCountry
        val viewModelFactory = DetailViewmodelFactory(countryData, application)
        binding.viewModel = ViewModelProvider(this, viewModelFactory).get(DetailViewmodel::class.java)
        binding.lifecycleOwner = this
        return binding.root
    }
}