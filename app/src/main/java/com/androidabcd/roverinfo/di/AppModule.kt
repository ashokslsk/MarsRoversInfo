package com.androidabcd.roverinfo.di

import android.content.Context
import com.androidabcd.roverinfo.db.MarsRoverSavedDatabase
import com.androidabcd.roverinfo.db.MarsRoverSavedPhotoDao
import com.androidabcd.roverinfo.service.MarsRoverInfoService
import com.androidabcd.roverinfo.service.MarsRoverPhotoService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

/**
 * Created by Ashok Kumar Srinivas on 11/09/23 around 4:57 pm
 * Youtuber on www.youtube.com/AndroidAbcd
 * Contact for any queries ashokslsk@gmail.com
 * Copyright (c) 2023 www.github.com/ashokslsk All rights reserved.
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideMarsRoverManifestService(): MarsRoverInfoService =
        MarsRoverInfoService.create()

    @Provides
    fun provideMarsRoverPhotoService(): MarsRoverPhotoService =
        MarsRoverPhotoService.create()

    @Provides
    fun providesMarsRoverSavedPhotoDao(@ApplicationContext context: Context): MarsRoverSavedPhotoDao =
        MarsRoverSavedDatabase.getInstance(context).marsRoverSavedPhotoDao()

}