package com.example.gitapi_kotlin.repoPackage

import androidx.recyclerview.widget.RecyclerView
import com.example.gitapi_kotlin.MainActivity.Companion.repoFullName
import com.example.gitapi_kotlin.MainActivity.Companion.repoName
import com.example.gitapi_kotlin.RepoAdapter
import com.google.gson.Gson
import kotlinx.coroutines.*
import java.net.URL
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.memberProperties

fun getData(user: String) = runBlocking{

    val response = async { URL("https://api.github.com/users/"+user+"/repos").readText() }
    return@runBlocking Gson().fromJson(response.await(), Array<Response>::class.java)
}

fun getRepo(user:String) = GlobalScope.launch{
    val data = getData(user)

    for(i in 0 until data.size){
        repoName.add(data[i].name)
        repoFullName.add(data[i].fullName)
    }
}
