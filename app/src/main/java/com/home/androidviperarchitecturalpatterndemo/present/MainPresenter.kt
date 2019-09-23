package com.home.androidviperarchitecturalpatterndemo.present

import com.home.androidviperarchitecturalpatterndemo.interactor.MainInteractor
import com.home.androidviperarchitecturalpatterndemo.view.activity.MainActivity
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val activity: MainActivity,
    private val interactor: MainInteractor
) {

    var disposable: Disposable? = null

    fun getPlantData() {
        disposable = interactor.getPlantData().subscribe { mainEntity ->
            mainEntity?.let { activity.initializeRecyclerView(mainEntity) }
        }
    }

    fun disposableDispose() {
        if (disposable != null && disposable?.isDisposed == false) {
            disposable?.dispose() // 取消訂閱
        }
    }
}