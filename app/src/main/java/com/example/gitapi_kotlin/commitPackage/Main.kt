package com.example.gitapi_kotlin.commitPackage

import com.google.gson.Gson
import kotlinx.coroutines.*
import java.net.URL
import com.example.gitapi_kotlin.CommitActivity.Companion.authorName
import com.example.gitapi_kotlin.CommitActivity.Companion.avatar
import com.example.gitapi_kotlin.CommitActivity.Companion.date
import com.example.gitapi_kotlin.CommitActivity.Companion.message

fun getData(user: String) = runBlocking{
    val response = async { URL("https://api.github.com/repos/"+user+"/commits").readText() }
    return@runBlocking Gson().fromJson(response.await(), Array<Response>::class.java)
}

fun getCommits(user: String) = GlobalScope.launch{
    authorName.clear()
    date.clear()
    avatar.clear()
    message.clear()

    val data = getData(user)

    if(data.size > 10){
        for(i in 0 until 10){
            authorName.add(data[i].commit?.author?.name.toString())
            date.add(data[i].commit?.author?.date.toString())
            avatar.add(data[i].author?.avatarUrl.toString())
            message.add(data[i].commit?.message.toString())
        }
    }
    else{
        for(i in 0 until data.size){
            authorName.add(data[i].commit?.author?.name.toString())
            date.add(data[i].commit?.author?.date.toString())
            avatar.add(data[i].author?.avatarUrl.toString())
            message.add(data[i].commit?.message.toString())
        }
    }
}