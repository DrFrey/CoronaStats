package com.example.coronastats.details

import android.app.Application
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.util.Log
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blongho.country_data.World
import com.example.coronastats.network.CountryData

class DetailViewmodel(countryData: CountryData, application: Application): AndroidViewModel(application) {
    private val _selectedCountry = MutableLiveData<CountryData>()
    val selectedCountry: LiveData<CountryData>
        get() = _selectedCountry

    val countryFlag: Drawable?

    init {
        _selectedCountry.value = countryData
        countryFlag = ResourcesCompat.getDrawable(application.resources, World.getFlagOf(countryData.country), null)
    }
}