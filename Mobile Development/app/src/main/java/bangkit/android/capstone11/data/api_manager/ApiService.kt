package bangkit.android.capstone11.data.api_manager

import bangkit.android.capstone11.data.api_manager.api_response.LoginResponse
import bangkit.android.capstone11.data.api_manager.api_response.MockUser
import bangkit.android.capstone11.data.api_manager.api_response.RegisterResult
import bangkit.android.capstone11.data.api_manager.api_response.ScanResponse
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path

interface ApiService {
    @FormUrlEncoded
    @POST("api/auth/signup")
    suspend fun register(
        @Field("username") username: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): RegisterResult

    @FormUrlEncoded
    @POST("api/auth/signin")
    suspend fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): LoginResponse

    //ini permisalan yang di atas
    @FormUrlEncoded
    @GET("users/{id}")
    suspend fun loginWhy(
        @Path("id") id: String
    ): Call<MockUser>

    @Multipart
    @POST("api/predict")
    suspend fun postImage(
        @Part file: MultipartBody.Part
    ): ScanResponse
}