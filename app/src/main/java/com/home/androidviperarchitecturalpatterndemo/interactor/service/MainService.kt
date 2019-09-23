package com.home.androidviperarchitecturalpatterndemo.interactor.service

import com.home.androidviperarchitecturalpatterndemo.entity.MainEntity
import io.reactivex.Observable
import retrofit2.http.GET

interface MainService {

    @GET("apiAccess?scope=resourceAquire&rid=f18de02f-b6c9-47c0-8cda-50efad621c14&limit=40")
    fun getPlantData(): Observable<MainEntity>
}