package com.androidabcd.roverinfo.service.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Ashok Kumar Srinivas on 13/09/23 around 10:24 am
 * Youtuber on www.youtube.com/AndroidAbcd
 * Contact for any queries ashokslsk@gmail.com
 * Copyright (c) 2023 www.github.com/ashokslsk All rights reserved.
 */
data class RoverRemoteModel(
    val id: Int,
    @field:SerializedName("landing_date") val landingDate: String,
    @field:SerializedName("launch_date") val lauchDate: String,
    val name:String,
    val status: String
)