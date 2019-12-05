package com.example.gitapi_kotlin

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gitapi_kotlin.MainActivity.Companion.repoFullName
import com.example.gitapi_kotlin.MainActivity.Companion.repoName
import kotlinx.android.synthetic.main.repo_item.view.*

class RepoAdapter() : RecyclerView.Adapter<RepoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.repo_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = repoName.size

    //Insert repo data from arrays to repo_item
    override fun onBindViewHolder(holder: RepoAdapter.ViewHolder, position: Int) {
        holder.nameView.text = repoName[position]
    }

    //ViewHolder inner class
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val nameView: TextView = view.repoName

        //OnClick listener
        //Export item's full_name
        init {
            itemView.setOnClickListener {
                val intent = Intent(view.context, CommitActivity::class.java)
                intent.putExtra("repository", repoFullName[adapterPosition])
                view.context.startActivity(intent)
            }
        }
    }
}