package com.example.coronastats.network

/*
data class CountryData(
    val infected: Int,
    val tested: Int,
    val recovered: Int,
    val deceased: Int,
    val country: String,
    val moreData: String,
    val historyData: String,
    val sourceUrl: String,
    val lastUpdatedApify: String
)
*/
data class CountryData(
    val infected: String,
    val tested: String,
    val recovered: String,
    val deceased: String,
    val country: String,
    val moreData: String?,
    val historyData: String?,
    val sourceUrl: String?,
    val lastUpdatedApify: String
)