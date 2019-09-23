package com.home.androidviperarchitecturalpatterndemo.di.component

import com.home.androidviperarchitecturalpatterndemo.di.module.MainModule
import com.home.androidviperarchitecturalpatterndemo.view.activity.MainActivity
import dagger.Component

@Component(modules = [MainModule::class], dependencies = [AvapdApplicationComponent::class])
interface MainComponent {

    /**
     * 告訴Component到MainActivity中, 去找所有被@Inject的物件
     */
    fun inject(mainActivity: MainActivity)
}