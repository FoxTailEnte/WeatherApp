package com.example.weatherapi


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weatherapi.databinding.ActivityMainBinding
import com.example.weatherapi.fragments.MainFragment

const val API_KEY = "2b2de22111a54ecdae4124357220111"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.placeHolder, MainFragment.newInstance())
            .commit()
    }
}