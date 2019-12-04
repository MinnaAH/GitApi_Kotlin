package com.example.gitapi_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gitapi_kotlin.repoPackage.getRepo
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.recyclerView

class MainActivity : AppCompatActivity() {
    companion object{
        var repoName =  ArrayList<String>()
        var repoFullName =  ArrayList<String>()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager = LinearLayoutManager(this)

    }

    fun userRepos(view: View){
        val user = username.text.toString()

        if(user.isNullOrEmpty()){
            Log.d("Username error:", user)
        }
        else{
            var job = getRepo(user)
            while(job.isActive) println("active: " + job.isActive)
            //for(i in repoName) println("globaali repo array " + i)
            recyclerView.adapter = RepoAdapter()
        }
    }
}
