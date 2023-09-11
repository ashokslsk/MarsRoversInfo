package com.androidabcd.roverinfo.data

import com.androidabcd.roverinfo.domain.model.RoverManifestUiState
import com.androidabcd.roverinfo.domain.model.toUiModel
import com.androidabcd.roverinfo.service.MarsRoverInfoService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created by Ashok Kumar Srinivas on 11/09/23 around 5:17 pm
 * Youtuber on www.youtube.com/AndroidAbcd
 * Contact for any queries ashokslsk@gmail.com
 * Copyright (c) 2023 www.github.com/ashokslsk All rights reserved.
 */
class MarsRoverManifestRepo @Inject constructor(
    private val marsRoverInfoService: MarsRoverInfoService
) {
    fun getMarsRoverManifest(roverName:String) : Flow<RoverManifestUiState> = flow{
        try {
            emit(
                toUiModel(
                    marsRoverInfoService.getMarsRoverManifest(
                        roverName.lowercase()
                    )
                )
            )
        }catch (throwble: Throwable){
            emit(RoverManifestUiState.Error)
        }
    }
}