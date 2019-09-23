package com.home.androidviperarchitecturalpatterndemo.router

import android.app.Activity
import android.content.Intent
import com.home.androidviperarchitecturalpatterndemo.entity.MainEntity
import com.home.androidviperarchitecturalpatterndemo.view.activity.DetailActivity

const val RESULTS_EXTRA = "RESULTS_EXTRA"

fun goToDetailActivity(activity: Activity, results: MainEntity.Result.Results) {
    val intent = Intent(activity, DetailActivity::class.java)
    intent.putExtra(RESULTS_EXTRA, results)
    activity.startActivity(intent)
}