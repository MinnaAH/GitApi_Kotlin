package com.example.gitapi_kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.commit_item.view.*
import com.example.gitapi_kotlin.CommitActivity.Companion.authorName
import com.example.gitapi_kotlin.CommitActivity.Companion.avatar
import com.example.gitapi_kotlin.CommitActivity.Companion.date
import com.example.gitapi_kotlin.CommitActivity.Companion.message

class CommitAdapter() : RecyclerView.Adapter<CommitAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommitAdapter.ViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater.inflate(R.layout.commit_item, parent, false)
            return ViewHolder(view)


    }

    override fun getItemCount(): Int = date.size

    override fun onBindViewHolder(holder: CommitAdapter.ViewHolder, position: Int) {
        println("author[position]"+authorName[position])
        holder.authorView.text = authorName[position]
        holder.dateView.text = date[position]
        holder.timeView.text = date[position]
        holder.messageView.text = message[position]

        //holder.authorView.text = authorObj["name"].toString()
        /*Glide.with(holder.pictureImageView.context)
            .load(commit["image"].toString())
            .into(holder.pictureImageView)
        holder.authorView.text = commit["commit"].toString()*/
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        val authorView: TextView = view.author
        val dateView: TextView = view.date
        val timeView: TextView = view.time
        val messageView: TextView = view.message
        //var pictureImageView: ImageView = view.avatar

    }
}