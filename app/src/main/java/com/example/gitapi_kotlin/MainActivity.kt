package com.example.gitapi_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gitapi_kotlin.repoPackage.getRepo
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.recyclerView

class MainActivity : AppCompatActivity() {
    companion object {
        var repoName = ArrayList<String>()
        var repoFullName = ArrayList<String>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)

    }

    //Get user repositories
    fun userRepos(view: View){

        val user = username.text.toString()
        if(user.isNullOrEmpty())Toast.makeText(getApplicationContext(), "Enter username before search!", Toast.LENGTH_LONG).show()
        else{

            var job = getRepo(user)
            while(job.isActive){}
            if(repoFullName.isEmpty())Toast.makeText(getApplicationContext(), "No public repositories available", Toast.LENGTH_LONG).show()
            else if (repoFullName[0]== "null")Toast.makeText(getApplicationContext(), "User not found!", Toast.LENGTH_LONG).show()
            else recyclerView.adapter = RepoAdapter()
        }
    }
}


