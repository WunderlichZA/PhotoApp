package com.simfyafrica.simfyassessmentv21.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.simfyafrica.simfyassessmentv21.dao.PhotoDAO
import com.simfyafrica.simfyassessmentv21.model.Photo

class PhotoRepository (private val photoDAO: PhotoDAO){

    val allWords: LiveData<List<Photo>> = photoDAO.getAllPhotos()

    @WorkerThread
    suspend fun insert(photo: Photo) {
        photoDAO.insert(photo)
    }
}