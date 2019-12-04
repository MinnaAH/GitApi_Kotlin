package com.example.gitapi_kotlin.repoPackage

import com.example.gitapi_kotlin.MainActivity.Companion.repoFullName
import com.example.gitapi_kotlin.MainActivity.Companion.repoName
import com.google.gson.Gson
import kotlinx.coroutines.*
import java.net.URL

fun getData(user: String) = runBlocking{

    val response = async { URL("https://api.github.com/users/"+user+"/repos").readText() }
    return@runBlocking Gson().fromJson(response.await(), Array<Response>::class.java)
}

fun getRepo(user:String) = GlobalScope.launch{
    repoFullName.clear()
    repoName.clear()

    val data = getData(user)

    for(i in 0 until data.size){
        repoName.add(data[i].name)
        repoFullName.add(data[i].fullName)
    }
}
