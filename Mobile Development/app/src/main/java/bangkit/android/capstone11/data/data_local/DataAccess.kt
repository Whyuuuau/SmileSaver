package bangkit.android.capstone11.data.data_local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

//@Dao
//interface DataAccess {
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun addStories(stories: List<ListStoryItem>)
//
//    @Query("SELECT * FROM story")
//    fun getStories(): PagingSource<Int, ListStoryItem>
//
//    @Query("DELETE FROM story")
//    suspend fun deleteAll()
//}