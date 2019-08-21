package com.simfyafrica.simfyassessmentv21.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.simfyafrica.simfyassessmentv21.dao.PhotoDAO
import com.simfyafrica.simfyassessmentv21.model.Photo


@Database(entities = arrayOf(Photo::class), version = 1)
abstract class PhotoRoomDatabase : RoomDatabase() {
    abstract fun photoDAO() : PhotoDAO

    companion object {
        @Volatile
        private var INSTANCE: PhotoRoomDatabase? = null

        fun getDatabase(context: Context): PhotoRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PhotoRoomDatabase::class.java,
                    "Word_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}