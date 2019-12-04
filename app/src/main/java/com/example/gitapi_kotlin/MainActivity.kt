package com.example.gitapi_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gitapi_kotlin.repoPackage.getRepo
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.recyclerView
import java.io.FileNotFoundException
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    companion object {
        var userName = ArrayList<String>()
        var repoName = ArrayList<String>()
        var repoFullName = ArrayList<String>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager = LinearLayoutManager(this)

    }

    fun userRepos(view: View){
        val user = username.text.toString()


        if(user.isNullOrEmpty()){
            Toast.makeText(getApplicationContext(), "Enter username before search!", Toast.LENGTH_LONG).show()
        }
        else{
            var job = getRepo(user)
            while(job.isActive) println("active: " + job.isActive)
            if(repoName.isEmpty())println("Repo empty")
            else recyclerView.adapter = RepoAdapter()
            }

        }
    }

