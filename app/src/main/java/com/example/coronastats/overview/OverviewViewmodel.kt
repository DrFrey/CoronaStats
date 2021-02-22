package com.example.coronastats.overview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coronastats.network.CoronaApi
import com.example.coronastats.network.CountryData
import kotlinx.coroutines.launch

class OverviewViewmodel: ViewModel() {

    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    private val _stats = MutableLiveData<List<CountryData>>()
    val stats: LiveData<List<CountryData>>
        get() = _stats

    init {
        getCoronaStats()
    }

    private fun getCoronaStats() {
        viewModelScope.launch {
            try {
                _stats.value = CoronaApi.retrofitService.getStatistics().sortedByDescending { it.infected.toInt() }
                _response.value = "Success: data received"
            } catch (e: Exception) {
                _response.value = "Failure: ${e.message}"
            }

        }
    }
}