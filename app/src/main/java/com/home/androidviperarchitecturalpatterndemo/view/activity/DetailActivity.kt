package com.home.androidviperarchitecturalpatterndemo.view.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.home.androidviperarchitecturalpatterndemo.R
import com.home.androidviperarchitecturalpatterndemo.entity.MainEntity
import com.home.androidviperarchitecturalpatterndemo.router.RESULTS_EXTRA
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initializeView()
    }

    @SuppressLint("SetTextI18n")
    private fun initializeView() {
        val intent = intent
        val results = intent.getSerializableExtra(RESULTS_EXTRA) as MainEntity.Result.Results
        text_view_title_name.text = results.fNameCh
        val empty = ""
        if (results.fNameCh == "") {
            text_view_name.text = empty
        } else {
            val title = "Name︰"
            text_view_name.text = title + results.fNameCh
        }
        if (results.fLocation == "") {
            text_view_location.text = empty
        } else {
            val title = "Location︰"
            text_view_location.text = title + results.fLocation
        }
        if (results.fAlsoKnown == "") {
            text_view_alsoKnown.text = empty
        } else {
            val title = "AlsoKnown︰"
            text_view_alsoKnown.text = title + results.fAlsoKnown
        }
        if (results.fFeature == "") {
            text_view_feature.text = empty
        } else {
            val title = "Feature︰"
            text_view_feature.text = title + results.fFeature
        }
        image_view_previous_page.setOnClickListener {
            finish()
        }
    }
}
