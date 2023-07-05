package com.pd.sportsnetwork

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SportsNetworkApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}
