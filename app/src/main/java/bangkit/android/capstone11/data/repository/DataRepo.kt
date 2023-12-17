package bangkit.android.capstone11.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import bangkit.android.capstone11.data.ResultResource
import bangkit.android.capstone11.data.Results
import bangkit.android.capstone11.data.api_manager.ApiService
import bangkit.android.capstone11.data.api_manager.api_response.LoginResponse
import bangkit.android.capstone11.data.api_manager.api_response.MockUser
import bangkit.android.capstone11.data.api_manager.api_response.RegisterResult
import bangkit.android.capstone11.data.api_manager.api_response.ScanResponse
import okhttp3.Call
import okhttp3.MultipartBody
import retrofit2.Callback
import retrofit2.Response

class DataRepo(
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

//    fun loginWhy(id: String): LiveData<ResultResource<MockUser>> = liveData {
//        val call: Call<MockUser> = apiService.loginWhy(id)
//        call.enqueue(object : Callback<MockUser> {
//            override fun onResponse(call: Call<MockUser>, response: Response<MockUser>) {
//                if (response.isSuccessful) {
//                    val user: MockUser? = response.body()
//                    Log.d(user)
//                } else {
//                    Log.d(null)
//                }
//            }
//
//            override fun onFailure(call: Call<MockUser>, t: Throwable) {
//                Log.d(null)
//            }
//        })
//    }

    fun postImage(
        file: MultipartBody.Part
    ): LiveData<Results<ScanResponse>> = liveData {
        emit(Results.Loading)
        try {
            val response = apiService.postImage(file)
            emit(Results.Success(response))
        } catch (e: Exception) {
            Log.d("post_image", e.message.toString())
            emit(Results.Error(e.message.toString()))
        }
    }
}