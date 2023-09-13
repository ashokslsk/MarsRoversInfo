package com.androidabcd.roverinfo.domain.model

/**
 * Created by Ashok Kumar Srinivas on 13/09/23 around 11:29 am
 * Youtuber on www.youtube.com/AndroidAbcd
 * Contact for any queries ashokslsk@gmail.com
 * Copyright (c) 2023 www.github.com/ashokslsk All rights reserved.
 */

sealed class RoverPhotoUiState{
    data class success (
        val roverPhotoUiModelList: List<RoverPhotoUiModel>
    ): RoverPhotoUiState()

    object Loading: RoverPhotoUiState()
    object Error: RoverPhotoUiState()
}
data class RoverPhotoUiModel (
    val id: Int,
    val roverName: String,
    val imgSrc: String,
    val sol: String,
    val earthDate: String,
    val camerFullName: String,
    val isSaved:Boolean
)