package com.etcmobileapps.burcyorumlari2020

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HiltApp: Application() {

    override fun onCreate() {
        super.onCreate()
    }

}