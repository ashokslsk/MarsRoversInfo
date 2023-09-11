package com.androidabcd.roverinfo.domain.model

import com.androidabcd.roverinfo.service.model.RoverManifestRemoteModel

/**
 * Created by Ashok Kumar Srinivas on 11/09/23 around 5:12 pm
 * Youtuber on www.youtube.com/AndroidAbcd
 * Contact for any queries ashokslsk@gmail.com
 * Copyright (c) 2023 www.github.com/ashokslsk All rights reserved.
 */
fun toUiModel(roverManifestRemoteModel: RoverManifestRemoteModel): RoverManifestUiState =
    RoverManifestUiState.Success(roverManifestRemoteModel.photoManifest.photos.map { photo ->
      RoverManifestUiModel(
          sol = photo.sol.toString(),
          earthDate = photo.earthDate,
          photoNumber = photo.totalPhotos.toString()
      )
    }.sorted())