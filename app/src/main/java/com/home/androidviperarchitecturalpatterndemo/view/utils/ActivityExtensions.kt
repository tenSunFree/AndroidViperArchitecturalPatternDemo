package com.home.androidviperarchitecturalpatterndemo.view.utils

import android.app.Activity
import com.home.androidviperarchitecturalpatterndemo.AvapdApplication
import com.home.androidviperarchitecturalpatterndemo.di.component.DaggerMainComponent
import com.home.androidviperarchitecturalpatterndemo.di.component.MainComponent
import com.home.androidviperarchitecturalpatterndemo.di.module.MainModule
import com.home.androidviperarchitecturalpatterndemo.view.activity.MainActivity

val Activity.applicationComponent
    get() = (application as AvapdApplication).getApplicationComponent()

val MainActivity.mainComponent: MainComponent
    get() = DaggerMainComponent
            .builder()
            .avapdApplicationComponent(applicationComponent)
            .mainModule(MainModule(this))
            .build()