package com.example.gitapi_kotlin.repoPackage

import android.app.AlertDialog
import android.widget.Toast
import com.example.gitapi_kotlin.MainActivity
import com.example.gitapi_kotlin.MainActivity.Companion.repoFullName
import com.example.gitapi_kotlin.MainActivity.Companion.repoName
import com.google.gson.Gson
import kotlinx.coroutines.*
import java.io.FileNotFoundException
import java.net.URL


fun getData(user: String): Array<Response> {
    return try{
        val response = URL("https://api.github.com/users/"+user+"/repos").readText()
        Gson().fromJson(response, Array<Response>::class.java)
    }catch (e:FileNotFoundException){
        //Toast/alert : user not found
        return arrayOf(Response())
    }
}

fun getRepo(user:String) = GlobalScope.launch{
    repoFullName.clear()
    repoName.clear()


    val data = getData(user)

    for(i in 0 until data.size){
        repoName.add(data[i].name.toString())
        repoFullName.add(data[i].fullName.toString())
    }

}
