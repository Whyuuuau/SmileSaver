package bangkit.android.capstone11.data.api_manager.api_response

import com.google.gson.annotations.SerializedName

data class UpdateResponse (
    @SerializedName("username") val username: String,
    @SerializedName("id") val id: Int,
    @SerializedName("email") val email: String
)
