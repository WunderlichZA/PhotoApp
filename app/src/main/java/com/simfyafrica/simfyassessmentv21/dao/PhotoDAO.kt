package com.simfyafrica.simfyassessmentv21.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.simfyafrica.simfyassessmentv21.model.Photo


@Dao
interface PhotoDAO {

    @Insert
    suspend fun insert(photo: Photo)

    @Query("SELECT * from photo_table ORDER BY title ASC")
    fun getAllPhotos() : LiveData<List<Photo>>
}