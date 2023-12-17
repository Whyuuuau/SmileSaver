package bangkit.android.capstone11.data.api_manager.api_response

import com.google.gson.annotations.SerializedName


data class LoginResponse(
    @SerializedName("username") val username: String,
    @SerializedName("id") val id: Int,
    @SerializedName("email") val email: String,
    @SerializedName("accessToken") val accessToken: String
)

