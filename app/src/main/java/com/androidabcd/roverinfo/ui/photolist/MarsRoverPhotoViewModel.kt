package com.androidabcd.roverinfo.ui.photolist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidabcd.roverinfo.data.MarsRoverPhotoRepo
import dagger.hilt.android.lifecycle.HiltViewModel
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
    fun getMarsRoverPhoto(roverName: String, sol: String){
        viewModelScope.launch {
            marsRoverPhotoRepo.getMarsRoverPhoto(roverName, sol).collect{

            }
        }
    }
}