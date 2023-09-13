package com.androidabcd.roverinfo.service.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Ashok Kumar Srinivas on 13/09/23 around 11:17 am
 * Youtuber on www.youtube.com/AndroidAbcd
 * Contact for any queries ashokslsk@gmail.com
 * Copyright (c) 2023 www.github.com/ashokslsk All rights reserved.
 */
data class PhotoRemoteModel(
    val camera: CameraRemoteModel,
    @field:SerializedName("earth_date") val earthDate:String,
    val id: Int,
    @field:SerializedName("img_src") val imgSrc: String,
    val rover: RoverRemoteModel,
    val sol: Int
)