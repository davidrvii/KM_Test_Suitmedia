package com.example.kmtest.data.response

import com.google.gson.annotations.SerializedName

data class UsersResponse(

	@field:SerializedName("data")
	val data: List<DataItem>,
)

data class DataItem(

	@field:SerializedName("last_name")
	val lastName: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("avatar")
	val avatar: String,

	@field:SerializedName("first_name")
	val firstName: String,

	@field:SerializedName("email")
	val email: String
)