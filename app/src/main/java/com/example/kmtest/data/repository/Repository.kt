package com.example.kmtest.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.kmtest.data.response.DataItem
import com.example.kmtest.data.retrofit.ApiService
import kotlinx.coroutines.Dispatchers

class Repository private constructor(
    private val apiService: ApiService
){

    fun getUsers(username: String) : LiveData<Result<List<DataItem>>> =
        liveData(Dispatchers.IO) {
            emit(Result.Loading)
            try {
                val response = apiService.getUsers(username)
                emit(Result.Success(response.data))
            } catch (e: Exception) {
                emit(Result.Error(e.message.toString()))
            }
        }

    companion object {
        @Volatile
        private var instance: Repository? = null
        fun getInstance(
            apiService: ApiService
        ): Repository = instance ?: synchronized(this) {
            instance ?: Repository(apiService)
        }.also { instance = it }
    }
}