package com.androidabcd.roverinfo.data

import com.androidabcd.roverinfo.db.MarsRoverSavedPhotoDao
import com.androidabcd.roverinfo.domain.model.RoverPhotoUiModel
import com.androidabcd.roverinfo.domain.model.RoverPhotoUiState
import com.androidabcd.roverinfo.service.MarsRoverPhotoService
import com.androidabcd.roverinfo.service.model.RoverPhotoRemoteModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created by Ashok Kumar Srinivas on 13/09/23 around 11:32 am
 * Youtuber on www.youtube.com/AndroidAbcd
 * Contact for any queries ashokslsk@gmail.com
 * Copyright (c) 2023 www.github.com/ashokslsk All rights reserved.
 */

class MarsRoverPhotoRepo @Inject constructor(
    private val marsRoverPhotoService: MarsRoverPhotoService,
    private val marsRoverSavedPhotoDao: MarsRoverSavedPhotoDao
){

    private fun getAllRemoteMarsRoverPhotos(roverName: String, sol: String): Flow<RoverPhotoRemoteModel?> = flow {
        try {
            val networkResult = marsRoverPhotoService.getMarsRoverPhotos(
                roverName.lowercase(),
                sol
            )
            emit(networkResult)
        }catch (throable: Throwable){
            emit(null)
        }

    }
    fun getMarsRoverPhoto(roverName: String, sol: String): Flow<RoverPhotoUiState> = flow{
       marsRoverSavedPhotoDao.allSavedIds(sol, roverName).combine(
           getAllRemoteMarsRoverPhotos(roverName, sol)
       ){
           local, remote->
           remote?.let { roverPhotoRemoteModel ->
               RoverPhotoUiState.success(
                   roverPhotoRemoteModel.photos.map { photo->
                       RoverPhotoUiModel(
                           id = photo.id,
                           roverName = photo.rover.name,
                           imgSrc = photo.imgSrc,
                           sol = photo.sol.toString(),
                           earthDate = photo.earthDate,
                           camerFullName = photo.camera.fullName,
                           isSaved = local.contains(photo.id)
                       )
                   }
               )
           }
       }?: kotlin.run {
           RoverPhotoUiState.Error
       }
    }

    suspend fun savePhoto(roverPhotoUiModel: RoverPhotoUiModel){

    }

    suspend fun removePhoto(roverPhotoUiModel: RoverPhotoUiModel){

    }
}