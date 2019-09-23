package com.home.androidviperarchitecturalpatterndemo.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.home.androidviperarchitecturalpatterndemo.R
import com.home.androidviperarchitecturalpatterndemo.entity.MainEntity
import com.home.androidviperarchitecturalpatterndemo.present.MainPresenter
import com.home.androidviperarchitecturalpatterndemo.view.adapter.MainAdapter
import com.home.androidviperarchitecturalpatterndemo.view.utils.mainComponent
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var presenter: MainPresenter

    @Inject
    lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainComponent.inject(this)
        presenter.getPlantData()
    }

    fun initializeRecyclerView(mainEntity: MainEntity) {
        adapter.setMainEntity(mainEntity)
        recycler_view.adapter = adapter
        val cacheSize = -1
        recycler_view.setItemViewCacheSize(cacheSize) // 解決複用錯亂的問題
    }

    override fun onDestroy() {
        presenter.disposableDispose()
        super.onDestroy()
    }
}
