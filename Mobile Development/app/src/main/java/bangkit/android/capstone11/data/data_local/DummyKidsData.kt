package bangkit.android.capstone11.data.data_local

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DummyKidsData(
    var name: String? = null,
    var gender: String? = null,
    var age: Int = 0,
    var address: String? = null,
    var fmg: Int = 0 ,
    var toothCondition: String? = null,
    var accuracy: String? = null
) : Parcelable
