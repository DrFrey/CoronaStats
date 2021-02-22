package com.example.coronastats.details

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.coronastats.network.CountryData
import java.lang.IllegalArgumentException

class DetailViewmodelFactory(
    private val countryData: CountryData,
    private val application: Application
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewmodel::class.java)) {
            return DetailViewmodel(countryData, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}