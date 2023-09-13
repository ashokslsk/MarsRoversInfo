package com.androidabcd.roverinfo.ui.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.androidabcd.roverinfo.ui.photolist.MarsRoverPhotoViewModel

/**
 * Created by Ashok Kumar Srinivas on 11/09/23 around 8:19 pm
 * Youtuber on www.youtube.com/AndroidAbcd
 * Contact for any queries ashokslsk@gmail.com
 * Copyright (c) 2023 www.github.com/ashokslsk All rights reserved.
 */

@Composable
fun PhotoScreen(
    roverName: String?,
    sol: String?,
    marsRoverPhotoViewModel: MarsRoverPhotoViewModel
){
    if (roverName != null && sol != null){
        LaunchedEffect(Unit){
            marsRoverPhotoViewModel.getMarsRoverPhoto(roverName, sol)
        }
    }
    Text(text = "Photo screen")
}