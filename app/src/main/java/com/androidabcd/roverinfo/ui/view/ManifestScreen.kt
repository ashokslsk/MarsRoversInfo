package com.androidabcd.roverinfo.ui.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.androidabcd.roverinfo.domain.model.RoverManifestUiState
import com.androidabcd.roverinfo.ui.manifestlist.MarsRoverManifestViewModel

/**
 * Created by Ashok Kumar Srinivas on 11/09/23 around 2:11 pm
 * Youtuber on www.youtube.com/AndroidAbcd
 * Contact for any queries ashokslsk@gmail.com
 * Copyright (c) 2023 www.github.com/ashokslsk All rights reserved.
 */

@Composable
fun ManifestScreen(
    roverName: String?,
    marsRoverManifestViewModel: MarsRoverManifestViewModel,
    onClick: (roverName: String, sol: String) -> Unit
){
    val viewState by marsRoverManifestViewModel.roverManifestUiState.collectAsStateWithLifecycle()

    if (roverName != null){
        LaunchedEffect(Unit){
            marsRoverManifestViewModel.getMarsRoverManifest(roverName)
        }

        when(val roverManifestUiState = viewState){
            RoverManifestUiState.Error -> Error()
            RoverManifestUiState.Loading -> Loading()
            is RoverManifestUiState.Success -> manifestList(
                roverManifestModelList = roverManifestUiState.roverManifestUiModelList,
                roverName = roverName,
                onClick = onClick )
        }
    }
}

@Preview
@Composable
fun ManifestScreenPreview(){
//    ManifestScreen("Perserverance")
}