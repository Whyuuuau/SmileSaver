package bangkit.android.capstone11.data.api_manager.api_response

//Kontak dokter, otw ga kepake
data class Contact(
    val id: Int,
    val name: String,
    val phone: String,
    val contact_link: String
)

//Informasi puskeskas, otw ga kepake
data class Information(
    val id: Int,
    val name: String,
    val image: String,
    val description: String
)

//Hasil model
data class Data(
    val class_name: String,
    val confidence_score: Double,
    val contact: Contact,
    val information: Information
)

//Dari scan response
data class Status(
    val code: Int,
    val message: String
)

//perumpaan hasil scan
data class ScanResponse(
    val data: Data,
    val status: Status
)