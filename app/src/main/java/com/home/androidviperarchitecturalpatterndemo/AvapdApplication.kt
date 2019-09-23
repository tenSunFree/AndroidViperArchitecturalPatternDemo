package com.home.androidviperarchitecturalpatterndemo

import android.app.Application
import com.home.androidviperarchitecturalpatterndemo.di.component.AvapdApplicationComponent
import com.home.androidviperarchitecturalpatterndemo.di.component.DaggerAvapdApplicationComponent
import com.home.androidviperarchitecturalpatterndemo.di.module.AvapdApplicationModule

class AvapdApplication : Application() {

    private lateinit var applicationComponent: AvapdApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerAvapdApplicationComponent
            .builder()
            .avapdApplicationModule(AvapdApplicationModule(applicationContext))
            .build()
    }

    fun getApplicationComponent(): AvapdApplicationComponent {
        return applicationComponent
    }
}