package com.androidabcd.roverinfo.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by Ashok Kumar Srinivas on 13/09/23 around 1:23 pm
 * Youtuber on www.youtube.com/AndroidAbcd
 * Contact for any queries ashokslsk@gmail.com
 * Copyright (c) 2023 www.github.com/ashokslsk All rights reserved.
 */
@Entity(tableName = "rover_photo")
data class MarsRoverSavedLocalModel (
    @PrimaryKey @field: SerializedName("rover_photo_id") val roverPhotoId:Int,
    @field:SerializedName("rover_photo") val roverName: String="",
    @field: SerializedName("img_src") val imgSrc: String="",
    @field: SerializedName("sol") val sol: String="",
    @field: SerializedName("earch_date") val earthDate: String="",
    @field: SerializedName("camer_fullname") val camerFullName: String="",
)