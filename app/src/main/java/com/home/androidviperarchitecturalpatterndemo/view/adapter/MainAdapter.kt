package com.home.androidviperarchitecturalpatterndemo.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.home.androidviperarchitecturalpatterndemo.R
import com.home.androidviperarchitecturalpatterndemo.entity.MainEntity
import com.home.androidviperarchitecturalpatterndemo.router.goToDetailActivity
import com.home.androidviperarchitecturalpatterndemo.view.activity.MainActivity
import javax.inject.Inject

class MainAdapter @Inject constructor(
    private val activity: MainActivity
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private var mainEntity: MainEntity? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_main_recycler_view_item, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position == 0) {
            Glide.with(holder.latestImageView.context).load(R.drawable.icon_latest)
                .into(holder.latestImageView)
            holder.latestImageView.visibility = View.VISIBLE
        } else {
            holder.latestImageView.visibility = View.GONE
        }
        if (mainEntity!!.result.results[position].fNameCh.length % 2 == 0) {
            Glide.with(holder.avatarImageView.context).load(R.drawable.icon_male_avatar)
                .into(holder.avatarImageView)
        } else {
            Glide.with(holder.avatarImageView.context).load(R.drawable.icon_female_avatar)
                .into(holder.avatarImageView)
        }
        holder.nameTextView.text = mainEntity!!.result.results[position].fNameCh
        holder.contentTextView.text = mainEntity!!.result.results[position].fBrief
        holder.mainView.setOnClickListener {
            goToDetailActivity(activity, mainEntity!!.result.results[position])
        }
    }

    override fun getItemCount(): Int {
        return mainEntity!!.result.results.size
    }

    fun setMainEntity(mainEntity: MainEntity) {
        this.mainEntity = mainEntity
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val latestImageView: ImageView = itemView.findViewById(R.id.image_view_latest)
        val avatarImageView: ImageView = itemView.findViewById(R.id.image_view_avatar)
        val nameTextView: TextView = itemView.findViewById(R.id.text_view_name)
        val contentTextView: TextView = itemView.findViewById(R.id.text_view_content)
        val mainView: View = itemView.findViewById(R.id.view_main)
    }
}