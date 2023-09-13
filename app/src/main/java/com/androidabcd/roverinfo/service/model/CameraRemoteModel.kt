package com.androidabcd.roverinfo.service.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Ashok Kumar Srinivas on 13/09/23 around 10:21 am
 * Youtuber on www.youtube.com/AndroidAbcd
 * Contact for any queries ashokslsk@gmail.com
 * Copyright (c) 2023 www.github.com/ashokslsk All rights reserved.
 */
data class CameraRemoteModel(
    @field: SerializedName("full_name") val fullName:String,
    val id: Int,
    val name: String,
    @field: SerializedName("rover_id") val roverId: Int
)