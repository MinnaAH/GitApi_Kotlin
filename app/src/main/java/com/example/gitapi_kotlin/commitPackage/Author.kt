package com.example.gitapi_kotlin.commitPackage

import com.google.gson.annotations.SerializedName


data class Author(

	@field:SerializedName("date")
	val date: String = "",

	@field:SerializedName("name")
	val name: String = "",

	@field:SerializedName("avatar_url")
	val avatarUrl: String = ""
)