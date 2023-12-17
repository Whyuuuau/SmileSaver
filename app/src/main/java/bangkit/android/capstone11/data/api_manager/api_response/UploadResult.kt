package bangkit.android.capstone11.data.api_manager.api_response

import com.google.gson.annotations.SerializedName

data class UploadResult(
    @SerializedName("error") val error: Boolean,
    @SerializedName("message") val message: String
)