package com.home.androidviperarchitecturalpatterndemo.di.component

import android.content.Context
import com.home.androidviperarchitecturalpatterndemo.di.module.AvapdApplicationModule
import com.home.androidviperarchitecturalpatterndemo.di.module.ServiceModule
import com.home.androidviperarchitecturalpatterndemo.interactor.service.MainService
import dagger.Component

@Component(modules = [AvapdApplicationModule::class, ServiceModule::class])
interface AvapdApplicationComponent {

    fun getContext(): Context

    fun getMainService(): MainService
}