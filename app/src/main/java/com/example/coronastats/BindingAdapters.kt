package com.example.coronastats

import android.annotation.SuppressLint
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.coronastats.network.CountryData
import com.example.coronastats.overview.CoronaDataAdapter
import java.text.NumberFormat

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<CountryData>?) {
    val adapter = recyclerView.adapter as CoronaDataAdapter
    adapter.submitList(data)
}

@SuppressLint("NewApi")
@BindingAdapter("formattedNumber")
fun setFormattedNumber(textView: TextView, number: String?) {
    try {
     val formattedNumber = NumberFormat.getInstance().format(number?.toInt())
        textView.text = formattedNumber
    } catch (e: Exception) {
        textView.text = number
    }
}

