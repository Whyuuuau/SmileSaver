package com.example.toothscan.data_user.data_local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.toothscan.data_user.api_manager.api_response.ListStoryItem

@Dao
interface DataAccess {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addStories(stories: List<ListStoryItem>)

    @Query("SELECT * FROM story")
    fun getStories(): PagingSource<Int, ListStoryItem>

    @Query("DELETE FROM story")
    suspend fun deleteAll()
}