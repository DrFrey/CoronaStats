package com.example.coronastats

import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.NumberFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*


@BindingAdapter("formattedNumber")
fun setFormattedNumber(textView: TextView, number: String?) {
    if (number == null) {
        textView.text = "NA"
    } else {
        try {
            val formattedNumber = NumberFormat.getInstance().format(number.toInt())
            textView.text = formattedNumber
        } catch (e: Exception) {
            textView.text = number
        }
    }
}

@BindingAdapter("emptyLineAdapter")
fun setCorrectStringValue(textView: TextView, value: String?) {
    if (value != null) {
        textView.text = value
    } else {
        textView.text = "NA"
    }
}

@BindingAdapter("formattedDateTime")
fun setFormattedDateTime(textView: TextView, dateString: String?) {
    try {
        val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH)
        val inputDate = LocalDateTime.parse(dateString, inputFormatter)
        textView.text = inputDate.format((DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG, FormatStyle.SHORT)))
    } catch (e: Exception) {
        textView.text = dateString
    }
}