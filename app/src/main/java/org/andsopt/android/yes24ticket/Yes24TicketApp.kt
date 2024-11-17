package org.andsopt.android.yes24ticket

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class Yes24TicketApp : Application() {
    override fun onCreate() {
        super.onCreate()
        setTimber()
    }

    private fun setTimber() {
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}