package com.example.coronastats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.blongho.country_data.World

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        World.init(applicationContext)
    }
}