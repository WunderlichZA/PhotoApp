package com.simfyafrica.simfyassessmentv21.repository

import com.simfyafrica.simfyassessmentv21.model.Photo
import com.simfyafrica.simfyassessmentv21.network.CatApi

class WebServiceRepository(private val api : CatApi) : BaseRepository() {
    suspend fun getCatImages() : MutableList<Photo>?{

        val catResponse = safeApiCall(
            call = {api.getImages("json", 100, "small", "png").await()},
            errorMessage = "Error fetching popular movies"
        )
        return catResponse?.results?.toMutableList()
    }
}