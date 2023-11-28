package com.example.toothscan.model

import androidx.lifecycle.ViewModel
import com.example.toothscan.data_user.data_local.DataRepo
import okhttp3.MultipartBody
import okhttp3.RequestBody

class AddViewModel(
    private val repository: DataRepo
) : ViewModel() {

    fun postImage(
        file: MultipartBody.Part,
        description: RequestBody,
        lat: Double,
        lon: Double,
        token: String,
        multiPort: String
    ) = repository.postImage(file, description, lat, lon, token, multiPort)
}
