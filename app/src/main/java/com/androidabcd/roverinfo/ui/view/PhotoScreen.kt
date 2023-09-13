package com.androidabcd.roverinfo.ui.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.androidabcd.roverinfo.domain.model.RoverPhotoUiState
import com.androidabcd.roverinfo.ui.photolist.MarsRoverPhotoViewModel

/**
 * Created by Ashok Kumar Srinivas on 11/09/23 around 8:19 pm
 * Youtuber on www.youtube.com/AndroidAbcd
 * Contact for any queries ashokslsk@gmail.com
 * Copyright (c) 2023 www.github.com/ashokslsk All rights reserved.
 */

@Composable
fun PhotoScreen(
    modifier: Modifier,
    roverName: String?,
    sol: String?,
    marsRoverPhotoViewModel: MarsRoverPhotoViewModel
){
    val viewState by marsRoverPhotoViewModel.roverPhotoUiState.collectAsStateWithLifecycle()
    
    if (roverName != null && sol != null){
        LaunchedEffect(Unit){
            marsRoverPhotoViewModel.getMarsRoverPhoto(roverName, sol)
        }
        when(val roverPhotoUiState = viewState){
            RoverPhotoUiState.Error -> Error()
            RoverPhotoUiState.Loading -> Loading()
            is RoverPhotoUiState.success -> PhotoList(
                modifier = modifier,
                roverPhotoUiModelList = roverPhotoUiState.roverPhotoUiModelList,
                onClick = {})
        }
    }
}