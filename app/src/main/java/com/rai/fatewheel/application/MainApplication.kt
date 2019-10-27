package com.rai.fatewheel.application

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.rai.fatewheel.modules.appModules
import com.rai.fatewheel.modules.employeeListModule
import com.rai.fatewheel.modules.scheduleModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        instance = this
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        startKoin {
            androidContext(this@MainApplication)
            modules(appModules, employeeListModule, scheduleModule)

        }

    }


    companion object {
        var instance: MainApplication? = null
    }
}