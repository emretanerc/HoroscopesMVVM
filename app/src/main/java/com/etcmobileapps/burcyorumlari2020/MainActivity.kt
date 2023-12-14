package com.etcmobileapps.burcyorumlari2020

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.findNavController
import com.etcmobileapps.burcyorumlari2020.databinding.ActivityMainBinding
import com.etcmobileapps.burcyorumlari2020.ui.horoscopedetail.HoroscopeDetailViewModel
import com.onesignal.OneSignal
import com.onesignal.debug.LogLevel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

const val ONESIGNAL_APP_ID = "338b2830-d3d7-4cbd-806c-6f7a799cca16"
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

        OneSignal.Debug.logLevel = LogLevel.VERBOSE

        // OneSignal Initialization
        OneSignal.initWithContext(this, ONESIGNAL_APP_ID)

        // requestPermission will show the native Android notification permission prompt.
        // NOTE: It's recommended to use a OneSignal In-App Message to prompt instead.
        CoroutineScope(Dispatchers.IO).launch {
            OneSignal.Notifications.requestPermission(true)
        }
    }
}