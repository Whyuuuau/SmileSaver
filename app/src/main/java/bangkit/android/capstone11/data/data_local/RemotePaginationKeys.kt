package bangkit.android.capstone11.data.data_local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "remote_keys")
data class RemotePaginationKeys(

    @PrimaryKey val id: String,
    val prevKey: Int?,
    val nextKey: Int?
)