package bangkit.android.capstone11.data.data_local

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NearestDentist(
    val image: Int,
    val name: String,
    val address: String
) : Parcelable
