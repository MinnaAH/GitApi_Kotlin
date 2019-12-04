package com.example.gitapi_kotlin.commitPackage


import com.google.gson.annotations.SerializedName


data class Commit(

	@field:SerializedName("author")
	val author: Author? = null,

	@field:SerializedName("message")
	val message: String = ""

)