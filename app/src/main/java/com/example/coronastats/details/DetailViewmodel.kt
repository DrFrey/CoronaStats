package com.example.coronastats.details

import androidx.lifecycle.*
import com.example.coronastats.network.CountryData
import java.lang.IllegalArgumentException

class DetailViewmodel(countryData: CountryData): ViewModel() {
    private val _selectedCountry = MutableLiveData<CountryData>()
    val selectedCountry: LiveData<CountryData>
        get() = _selectedCountry

    init {
        _selectedCountry.value = countryData
    }
}

class DetailViewmodelFactory(
    private val countryData: CountryData,
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewmodel::class.java)) {
            return DetailViewmodel(countryData) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}