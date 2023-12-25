package com.example.kmtest.injection

import android.content.Context
import com.example.kmtest.data.repository.Repository
import com.example.kmtest.data.retrofit.ApiConfig

object Injection {
    fun provideRepository(context: Context): Repository {
        val apiService = ApiConfig.getApiService()
        return Repository.getInstance(apiService)
    }
}