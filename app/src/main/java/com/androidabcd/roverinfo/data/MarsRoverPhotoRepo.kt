package com.androidabcd.roverinfo.data

import com.androidabcd.roverinfo.domain.model.RoverPhotoUiModel
import com.androidabcd.roverinfo.domain.model.RoverPhotoUiState
import com.androidabcd.roverinfo.service.MarsRoverPhotoService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created by Ashok Kumar Srinivas on 13/09/23 around 11:32 am
 * Youtuber on www.youtube.com/AndroidAbcd
 * Contact for any queries ashokslsk@gmail.com
 * Copyright (c) 2023 www.github.com/ashokslsk All rights reserved.
 */

class MarsRoverPhotoRepo @Inject constructor(
    private val marsRoverPhotoService: MarsRoverPhotoService
){
    fun getMarsRoverPhoto(roverName: String, sol: String): Flow<RoverPhotoUiState> = flow{
        try{
            val networkResult = marsRoverPhotoService.getMarsRoberPhotos(roverName,sol)
            emit(RoverPhotoUiState.success(networkResult.photos.map {
                photo -> RoverPhotoUiModel(
                    id = photo.id,
                    imgSrc = photo.imgSrc,
                    roverName = photo.rover.name,
                    sol = photo.sol.toString(),
                    earthDate = photo.earthDate,
                    camerFullName = photo.camera.fullName
                )
            }))
        }catch (throwable: Throwable){
            emit(RoverPhotoUiState.Error)
        }
    }
}