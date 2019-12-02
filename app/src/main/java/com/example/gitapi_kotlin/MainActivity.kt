package com.example.gitapi_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    fun getRepo(user: String){
        val queue = Volley.newRequestQueue(this)
        val url = "https://api.github.com/users/"+user+"/repos"

        val jsonArrayRequest = JsonArrayRequest(Request.Method.GET, url, null, Response.Listener<JSONArray> {
            response ->
            recyclerView.adapter = RepoAdapter(response)
        },
        Response.ErrorListener { error ->
            Log.d("JSON Error",error.toString()) }
        )
        queue.add(jsonArrayRequest)
    }

    fun userRepos(view: View){
        val user = username.text.toString()

        if(user.isNullOrEmpty()){
            Log.d("Username error:", user)
        }
        else{
            getRepo(user)
        }
    }
}
