package com.example.gitapi_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gitapi_kotlin.commitPackage.getCommits
import kotlinx.android.synthetic.main.commit_activity.*


class CommitActivity : AppCompatActivity() {

    companion object{
        var authorName =  ArrayList<String>()
        var date =  ArrayList<String>()
        var avatar =  ArrayList<String>()
        var message =  ArrayList<String>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.commit_activity)

        recyclerView.layoutManager = LinearLayoutManager(this)
        repoCommits()
    }

    private fun repoCommits() {
        val data: Bundle? = intent.extras
        if (data != null) {
            val dataString = data!!.getString("repository")
            if (dataString != null) {
                var job = getCommits(dataString)

                while(job.isActive){}

                recyclerView.adapter = CommitAdapter()

            }
        }
    }
}