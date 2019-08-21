package com.simfyafrica.simfyassessmentv21.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiFactory {

    fun retrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.thecatapi.com/api/images/")
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val catApi: CatApi = retrofit().create(CatApi::class.java)
}