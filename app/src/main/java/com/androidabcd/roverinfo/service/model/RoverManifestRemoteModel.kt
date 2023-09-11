package com.androidabcd.roverinfo.service.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Ashok Kumar Srinivas on 11/09/23 around 4:03 pm
 * Youtuber on www.youtube.com/AndroidAbcd
 * Contact for any queries ashokslsk@gmail.com
 * Copyright (c) 2023 www.github.com/ashokslsk All rights reserved.
 */
data class RoverManifestRemoteModel(
    @field:SerializedName("photo_manifest")
    val photoManifest: PhotoManifestRemoteModel,
)