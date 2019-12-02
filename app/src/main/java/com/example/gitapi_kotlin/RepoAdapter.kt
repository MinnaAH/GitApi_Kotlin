package com.example.gitapi_kotlin

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import kotlinx.android.synthetic.main.repo_item.view.*

class RepoAdapter(private val repositories: JSONArray) : RecyclerView.Adapter<RepoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.repo_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = repositories.length()

    override fun onBindViewHolder(holder: RepoAdapter.ViewHolder, position: Int) {
        val repository = repositories.getJSONObject(position)
        holder.nameView.text = repository["name"].toString()
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val nameView: TextView = view.repoName

        init {
            itemView.setOnClickListener {
                val intent = Intent(view.context, CommitActivity::class.java)
                intent.putExtra("repository", repositories[adapterPosition].toString())
                view.context.startActivity(intent)
            }
        }
    }
}