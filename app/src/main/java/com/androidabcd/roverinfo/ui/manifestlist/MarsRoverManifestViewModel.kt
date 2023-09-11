package com.androidabcd.roverinfo.ui.manifestlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidabcd.roverinfo.data.MarsRoverManifestRepo
import com.androidabcd.roverinfo.domain.model.RoverManifestUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Ashok Kumar Srinivas on 11/09/23 around 5:24 pm
 * Youtuber on www.youtube.com/AndroidAbcd
 * Contact for any queries ashokslsk@gmail.com
 * Copyright (c) 2023 www.github.com/ashokslsk All rights reserved.
 */
@HiltViewModel
class MarsRoverManifestViewModel @Inject constructor(
    private val marsRoverManifestRepo: MarsRoverManifestRepo
): ViewModel(){


    private val _roverManifestUiState: MutableStateFlow<RoverManifestUiState> =
        MutableStateFlow(RoverManifestUiState.Loading)

     val roverManifestUiState: StateFlow<RoverManifestUiState>
        get() = _roverManifestUiState
    fun getMarsRoverManifest(roverName: String){
        viewModelScope.launch {
            _roverManifestUiState.value = RoverManifestUiState.Loading
            marsRoverManifestRepo.getMarsRoverManifest(roverName).collect{
                _roverManifestUiState.value = it
            }
        }
    }
}