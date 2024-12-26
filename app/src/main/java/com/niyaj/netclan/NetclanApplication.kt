package com.niyaj.netclan

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NetclanApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}