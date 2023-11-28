package com.example.toothscan.dependency

import android.content.Context
import com.example.toothscan.data_user.data_local.DataRepo
import com.example.toothscan.data_user.api_manager.ApiClient
import com.example.toothscan.data_user.data_local.DataStorage

object InjectionManager {
    fun provideRepository(context: Context): DataRepo {
        val database = DataStorage.getDatabase(context)
        val apiService = ApiClient.getApiService()
        return DataRepo(database, apiService)
    }
}