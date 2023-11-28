package com.example.toothscan.data_user.data_local

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.paging.ExperimentalPagingApi
import com.example.toothscan.data_user.api_manager.ApiService
import com.example.toothscan.data_user.api_manager.api_response.LoginResponse
import com.example.toothscan.data_user.api_manager.api_response.RegisterResult
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.toothscan.data_user.api_manager.api_response.UploadResult
import com.example.toothscan.data_user.api_manager.api_response.ListStoryItem
import com.example.toothscan.data_user.api_manager.api_response.StoryResponse
import com.example.toothscan.data_user.data_local.DataStorage
import okhttp3.MultipartBody
import okhttp3.RequestBody

class DataRepo(
    private val storyDatabase: DataStorage,
    private val apiService: ApiService
) {
    fun register(
        name: String,
        email: String,
        pass: String
    ): LiveData<ResultResource<RegisterResult>> = liveData {
        emit(ResultResource.Loading)
        try {
            val response = apiService.register(name, email, pass)
            emit(ResultResource.Success(response))
        } catch (e: Exception) {
            Log.d("register", e.message.toString())
            emit(ResultResource.Error(e.message.toString()))
        }
    }

    fun login(email: String, pass: String): LiveData<ResultResource<LoginResponse>> = liveData {
        emit(ResultResource.Loading)
        try {
            val response = apiService.login(email, pass)
            emit(ResultResource.Success(response))
        } catch (e: Exception) {
            Log.d("login", e.message.toString())
            emit(ResultResource.Error(e.message.toString()))
        }
    }

    fun getStories(token: String): LiveData<PagingData<ListStoryItem>> {
        @OptIn(ExperimentalPagingApi::class)
        return Pager(
            config = PagingConfig(
                pageSize = 5
            ),
            remoteMediator = PaginationMediator(storyDatabase, apiService, token),
            pagingSourceFactory = {
                storyDatabase.storyDao().getStories()
            }
        ).liveData
    }

    fun postImage(
        file: MultipartBody.Part,
        description: RequestBody,
        lat: Double,
        lon: Double,
        token: String,
        multiPort: String,
    ): LiveData<ResultResource<UploadResult>> = liveData {
        emit(ResultResource.Loading)
        try {
            val response = apiService.postImage(file, description, lat, lon, token, multiPort)
            emit(ResultResource.Success(response))
        } catch (e: Exception) {
            Log.d("post_image", e.message.toString())
            emit(ResultResource.Error(e.message.toString()))
        }
    }

    fun getWithLocation(location: Int, token: String): LiveData<ResultResource<StoryResponse>> =
        liveData {
            emit(ResultResource.Loading)
            try {
                val response = apiService.getStoriesWithLocation(location, token)
                emit(ResultResource.Success(response))
            } catch (e: Exception) {
                Log.d("story_maps", e.message.toString())
                emit(ResultResource.Error(e.message.toString()))
            }
        }




}