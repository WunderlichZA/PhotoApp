package com.simfyafrica.simfyassessmentv21.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.simfyafrica.simfyassessmentv21.model.Photo
import com.simfyafrica.simfyassessmentv21.network.ApiFactory
import com.simfyafrica.simfyassessmentv21.repository.WebServiceRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class WebServiceViewModel : ViewModel(){
    private val parentJob = Job()

    private val coroutineContext : CoroutineContext
        get() = parentJob + Dispatchers.Default

    private  val scope = CoroutineScope(coroutineContext)

    private val repository :  WebServiceRepository = WebServiceRepository(ApiFactory.catApi)

    val catImagesLiveData = MutableLiveData<MutableList<Photo>>()

    fun fetchCatImages(){
        scope.launch {
            val catImages = repository.getCatImages()
            catImagesLiveData.postValue(catImages)
        }
    }

    fun cancelAllRequests() = coroutineContext.cancel()
}