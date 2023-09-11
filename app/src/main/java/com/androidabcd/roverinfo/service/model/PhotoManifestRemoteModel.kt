package com.androidabcd.roverinfo.service.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Ashok Kumar Srinivas on 11/09/23 around 3:44 pm
 * Youtuber on www.youtube.com/AndroidAbcd
 * Contact for any queries ashokslsk@gmail.com
 * Copyright (c) 2023 www.github.com/ashokslsk All rights reserved.
 */
data class PhotoManifestRemoteModel (
    @field:SerializedName("landing_date")
    val landingDate: String,

    @field:SerializedName("lanch_date")
    val lanchDate: String,

    @field:SerializedName("max_date")
    val maxDate: String,

    @field:SerializedName("max_sol")
    val maxSol: String,

    @field:SerializedName("total_photos")
    val totalPhotos: Int,


    val name: String,
    val photos: List<ManifestPhotoRemoteModel>,
    val status: String,


)