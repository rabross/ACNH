package com.rabross.acnh

import android.app.Application
import com.rabross.acnh.core.di.CoreComponent
import com.rabross.acnh.core.di.CoreComponentProvider
import com.rabross.acnh.core.di.DaggerCoreComponent
import timber.log.Timber

class App : Application(), CoreComponentProvider {

    override val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent
            .factory()
            .create(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
