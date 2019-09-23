package com.home.androidviperarchitecturalpatterndemo.interactor

import com.home.androidviperarchitecturalpatterndemo.entity.MainEntity
import com.home.androidviperarchitecturalpatterndemo.interactor.service.MainService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainInteractor @Inject constructor(
    private val mainService: MainService
) {

    fun getPlantData(): Observable<MainEntity> {
        return mainService.getPlantData()
            .map { it }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}