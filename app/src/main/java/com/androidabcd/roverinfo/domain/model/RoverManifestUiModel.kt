package com.androidabcd.roverinfo.domain.model

/**
 * Created by Ashok Kumar Srinivas on 11/09/23 around 5:07 pm
 * Youtuber on www.youtube.com/AndroidAbcd
 * Contact for any queries ashokslsk@gmail.com
 * Copyright (c) 2023 www.github.com/ashokslsk All rights reserved.
 */

sealed class RoverManifestUiState{
    data class Success(
        val roverManifestUiModelList: List<RoverManifestUiModel>
    ):RoverManifestUiState()

    object Loading: RoverManifestUiState()
    object Error: RoverManifestUiState()
}
data class RoverManifestUiModel (
    val sol: String,
    val earthDate: String,
    val photoNumber: String
):Comparable<RoverManifestUiModel> {
    override fun compareTo(other: RoverManifestUiModel): Int = other.earthDate.compareTo(this.earthDate)
}