package com.home.androidviperarchitecturalpatterndemo.di.module

import com.home.androidviperarchitecturalpatterndemo.view.activity.MainActivity
import dagger.Module
import dagger.Provides

@Module
class MainModule(private val mainActivity: MainActivity) {

    @Provides
    fun providesMainActivity(): MainActivity = mainActivity
}