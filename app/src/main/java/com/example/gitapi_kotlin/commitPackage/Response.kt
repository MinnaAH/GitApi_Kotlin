package com.example.gitapi_kotlin.commitPackage

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("author")
	val author: Author? = null,

	@field:SerializedName("commit")
	val commit: Commit? = null
)