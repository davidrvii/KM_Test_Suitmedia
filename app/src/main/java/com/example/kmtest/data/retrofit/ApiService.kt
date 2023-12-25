package com.example.kmtest.data.retrofit

import com.example.kmtest.data.response.UsersResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("api/users")
    suspend fun getUsers(
        @Query("a") username : String
    ) : UsersResponse

    @GET("users/{username}")
    suspend fun getUserDetail(
        @Path("first_name") username: String
    )
}