package bangkit.android.capstone11.data.data_local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


//@Database(
//    entities = [ListStoryItem::class, RemotePaginationKeys::class],
//    version = 1,
//    exportSchema = false
//)
//abstract class DataStorage : RoomDatabase() {
//
//    abstract fun storyDao(): DataAccess
//    abstract fun remoteKeysDao(): RemotePaginationKeysDao
//
//    companion object {
//        @Volatile
//        private var INSTANCE: DataStorage? = null
//
//        fun getDatabase(context: Context): DataStorage {
//            return INSTANCE ?: synchronized(this) {
//                INSTANCE ?: buildDatabase(context).also {
//                    INSTANCE = it
//                }
//            }
//        }
//
//        private fun buildDatabase(context: Context): DataStorage {
//            return Room.databaseBuilder(
//                context.applicationContext,
//                DataStorage::class.java, "story_database"
//            )
//                .fallbackToDestructiveMigration()
//                .build()
//        }
//    }
//}