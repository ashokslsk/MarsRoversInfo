package com.androidabcd.roverinfo.ui.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.androidabcd.roverinfo.R
import com.androidabcd.roverinfo.domain.model.RoverManifestUiModel

/**
 * Created by Ashok Kumar Srinivas on 11/09/23 around 7:45 pm
 * Youtuber on www.youtube.com/AndroidAbcd
 * Contact for any queries ashokslsk@gmail.com
 * Copyright (c) 2023 www.github.com/ashokslsk All rights reserved.
 */


@Composable
fun manifestList(
    modifier: Modifier,
    roverManifestModelList: List<RoverManifestUiModel>,
    roverName: String,
    onClick: (roverName: String, sol: String) -> Unit
) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = modifier.fillMaxSize()
    ) {
        LazyColumn() {
            items(count = roverManifestModelList.size, itemContent = { index ->
                manifest(
                    roverManifestModel = roverManifestModelList[index],
                    roverName,
                    onClick
                )
            })
        }

    }
}

@Preview
@Composable
fun manifestPreview() {
    manifest(
        roverManifestModel = RoverManifestUiModel(
            sol = "4",
            earthDate = "2021 -03-05",
            photoNumber = "34"
        ), roverName = "",
        onClick = {_, _ -> }

    )
}

@Composable
fun manifest(
    roverManifestModel: RoverManifestUiModel,
    roverName: String,
    onClick: (roverName: String, sol: String) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clickable {
                //Click CTA
                onClick(roverName, roverManifestModel.sol)
            }

    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = stringResource(id = R.string.sol, roverManifestModel.sol))
            Text(text = stringResource(id = R.string.earth_date, roverManifestModel.earthDate))
            Text(
                text = stringResource(
                    id = R.string.number_of_photos,
                    roverManifestModel.photoNumber
                )
            )
        }
    }
}