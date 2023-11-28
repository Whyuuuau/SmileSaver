package com.example.toothscan.data_user.data_local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "remote_keys")
data class RemotePaginationKeys(

    @PrimaryKey val id: String,
    val prevKey: Int?,
    val nextKey: Int?
)
