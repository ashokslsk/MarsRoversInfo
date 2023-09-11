package com.androidabcd.roverinfo.service

import com.androidabcd.roverinfo.BuildConfig
import com.androidabcd.roverinfo.service.model.RoverManifestRemoteModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Ashok Kumar Srinivas on 11/09/23 around 3:43 pm
 * Youtuber on www.youtube.com/AndroidAbcd
 * Contact for any queries ashokslsk@gmail.com
 * Copyright (c) 2023 www.github.com/ashokslsk All rights reserved.
 */
interface MarsRoverInfoService {

    @GET("mars-photos/api/v1/manifests/{rover_name}?api_key=$API_KEY")
    suspend fun getMarsRoverManifest(@Path("rover_name") roverName: String): RoverManifestRemoteModel

    companion object{
        private const val BASE_URL = "https://api.nasa.gov/"
        private const val API_KEY = "uMNPdTULM2JQU0hLITrGhLLWnUy4QNebmbxraRdK"

        fun create(): MarsRoverInfoService{
            val logger =  HttpLoggingInterceptor()
            // If buildConfig doesn't appear in your project check if your
            // Buildfeature is enabled for buildConfig.
            logger.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BASIC else HttpLoggingInterceptor.Level.NONE

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MarsRoverInfoService::class.java)
        }
    }
}