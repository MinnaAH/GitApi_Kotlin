package com.example.gitapi_kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.commit_item.view.*
import com.example.gitapi_kotlin.CommitActivity.Companion.authorName
import com.example.gitapi_kotlin.CommitActivity.Companion.avatar
import com.example.gitapi_kotlin.CommitActivity.Companion.date
import com.example.gitapi_kotlin.CommitActivity.Companion.message
import com.squareup.picasso.Picasso
import java.time.Instant
import java.time.ZoneId
import java.util.*

class CommitAdapter() : RecyclerView.Adapter<CommitAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommitAdapter.ViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater.inflate(R.layout.commit_item, parent, false)
            return ViewHolder(view)


    }

    override fun getItemCount(): Int = date.size

    //Insert commit data from arrays to commit_item
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var instant = Instant.parse(date[position])
        var localDate = Date.from(instant).toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
        var localTime =  Date.from(instant).toInstant().atZone(ZoneId.systemDefault()).toLocalTime()

        holder.authorView.text = "Author: " + authorName[position]
        holder.dateView.text = "Date: " + localDate
        holder.timeView.text = "Time: " + localTime
        holder.messageView.text = "Message: " + message[position]

        if(avatar[position] != ""){
            Picasso
                .get()
                .load(avatar[position])
                .fit()
                .into(holder.pictureImageView)
        }
    }

    //ViewHolder inner class
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        val authorView: TextView = view.author
        val dateView: TextView = view.date
        val timeView: TextView = view.time
        val messageView: TextView = view.message
        var pictureImageView: ImageView = view.avatar

    }
}