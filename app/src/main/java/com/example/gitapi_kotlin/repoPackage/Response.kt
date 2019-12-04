package com.example.gitapi_kotlin.repoPackage

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("full_name")
	val fullName: String? = null,

	@field:SerializedName("name")
	val name: String? = null
)