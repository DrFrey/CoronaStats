package com.example.coronastats.network

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CountryData(
    val infected: String,
    val tested: String?,
    val recovered: String?,
    val deceased: String?,
    val country: String,
    val moreData: String?,
    val historyData: String?,
    val sourceUrl: String?,
    val lastUpdatedApify: String
): Parcelable