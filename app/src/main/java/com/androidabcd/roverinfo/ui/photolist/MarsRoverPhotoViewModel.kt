package com.androidabcd.roverinfo.ui.photolist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidabcd.roverinfo.data.MarsRoverPhotoRepo
import com.androidabcd.roverinfo.domain.model.RoverPhotoUiState
import com.androidabcd.roverinfo.ui.view.Rover
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Ashok Kumar Srinivas on 13/09/23 around 11:39 am
 * Youtuber on www.youtube.com/AndroidAbcd
 * Contact for any queries ashokslsk@gmail.com
 * Copyright (c) 2023 www.github.com/ashokslsk All rights reserved.
 */
@HiltViewModel
class MarsRoverPhotoViewModel @Inject constructor(
    private val marsRoverPhotoRepo: MarsRoverPhotoRepo
): ViewModel(){

    private val _roverPhotoUiState: MutableStateFlow<RoverPhotoUiState> = MutableStateFlow(RoverPhotoUiState.Loading)
    val roverPhotoUiState: StateFlow<RoverPhotoUiState>
        get() = _roverPhotoUiState
    fun getMarsRoverPhoto(roverName: String, sol: String){
        viewModelScope.launch {
            _roverPhotoUiState.value = RoverPhotoUiState.Loading
            marsRoverPhotoRepo.getMarsRoverPhoto(roverName, sol).collect{
                _roverPhotoUiState.value = it
            }
        }
    }
}