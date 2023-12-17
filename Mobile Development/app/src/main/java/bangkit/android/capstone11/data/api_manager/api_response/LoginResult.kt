package bangkit.android.capstone11.data.api_manager.api_response

import com.google.gson.annotations.SerializedName

//data class LoginResponse(
//    @SerializedName("loginResult") val loginResult: LoginResult,
//    @SerializedName("error") val error: Boolean,
//    @SerializedName("message") val message: String
//)
data class LoginResponse(
    @SerializedName("username") val username: String,
    @SerializedName("id") val id: String,
    @SerializedName("email") val email: String,
    @SerializedName("accessToken") val accessToken: String
)

data class LoginResult(
    @SerializedName("username") val username: String,
    @SerializedName("id") val id: String,
    @SerializedName("email") val email: String,
    @SerializedName("accessToken") val accessToken: String
)

//percobaan buat mock
data class LoginRes(
    val status: Int,
    val message: String,
    val id: String,
    val username: String,
    val email: String,
    val roles: String,
    val accessToken: String
)

data class MockUser(
    val id: String,
    val email: String,
    val password: String,
    val nama_lengkap: String,
    val tempat_lahir: String,
    val tanggal_lahir: String,
    val jenis_kelamin: String,
    val umur: Int,
    val username: String,
    val frekuensi: Int,
)