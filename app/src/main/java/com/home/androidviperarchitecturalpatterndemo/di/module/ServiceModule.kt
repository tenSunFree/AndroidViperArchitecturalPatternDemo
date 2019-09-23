package com.home.androidviperarchitecturalpatterndemo.di.module

import com.home.androidviperarchitecturalpatterndemo.interactor.service.MainService
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_PHRASES_URL: String = "https://data.taipei/opendata/datalist/"

@Module
class ServiceModule {

    @Provides
    fun providesMainService(): MainService = Retrofit.Builder()
            .baseUrl(BASE_PHRASES_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(MainService::class.java)
}