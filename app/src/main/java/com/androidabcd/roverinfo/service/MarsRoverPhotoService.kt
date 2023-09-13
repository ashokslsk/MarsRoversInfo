package com.androidabcd.roverinfo.service

import com.androidabcd.roverinfo.BuildConfig
import com.androidabcd.roverinfo.service.model.RoverPhotoRemoteModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Ashok Kumar Srinivas on 13/09/23 around 11:20 am
 * Youtuber on www.youtube.com/AndroidAbcd
 * Contact for any queries ashokslsk@gmail.com
 * Copyright (c) 2023 www.github.com/ashokslsk All rights reserved.
 */
interface MarsRoverPhotoService {

    @GET("mars-photos/api/v1/rovers/{rover_name}/photos?sol=1000&page=1&api_key=$API_KEY")
    suspend fun getMarsRoverPhotos(
        @Path("rover_name") roverName: String,
        @Query("sol") sol: String
    ): RoverPhotoRemoteModel

    companion object{
        private const val BASE_URL = "https://api.nasa.gov/"
        private const val API_KEY = "uMNPdTULM2JQU0hLITrGhLLWnUy4QNebmbxraRdK"


        fun create(): MarsRoverPhotoService{
            val logger = HttpLoggingInterceptor()
            logger.level = if(BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BASIC else HttpLoggingInterceptor.Level.NONE

             val client = OkHttpClient.Builder()
                 .addInterceptor(logger)
                 .build()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MarsRoverPhotoService::class.java)
        }
    }
}