package com.etcmobileapps.burcyorumlari2020

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.findNavController
import com.etcmobileapps.burcyorumlari2020.databinding.ActivityMainBinding
import com.etcmobileapps.burcyorumlari2020.ui.horoscopedetail.HoroscopeDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        findNavController(R.id.container).navigate(R.id.horoscopesFragment)

        binding!!.bottomNavigationView.setOnItemSelectedListener{
            when (it.itemId) {
                R.id.horoscope -> {
                    findNavController(R.id.container).navigate(R.id.horoscopesFragment)
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }
}