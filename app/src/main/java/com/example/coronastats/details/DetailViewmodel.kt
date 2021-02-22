package com.example.coronastats.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coronastats.network.CountryData

class DetailViewmodel(countryData: CountryData, application: Application): AndroidViewModel(application) {
    private val _selectedCountry = MutableLiveData<CountryData>()
    val selectedCountry: LiveData<CountryData>
        get() = _selectedCountry

    init {
        _selectedCountry.value = countryData
    }
}