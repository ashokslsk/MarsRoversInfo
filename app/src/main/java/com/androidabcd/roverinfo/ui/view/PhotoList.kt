package com.androidabcd.roverinfo.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.androidabcd.roverinfo.R
import com.androidabcd.roverinfo.domain.model.RoverPhotoUiModel

/**
 * Created by Ashok Kumar Srinivas on 13/09/23 around 11:50 am
 * Youtuber on www.youtube.com/AndroidAbcd
 * Contact for any queries ashokslsk@gmail.com
 * Copyright (c) 2023 www.github.com/ashokslsk All rights reserved.
 */

@Composable
fun PhotoList(
    modifier: Modifier,
    roverPhotoUiModelList: List<RoverPhotoUiModel>,
    onClick: (roverPhotoUiModel: RoverPhotoUiModel) -> Unit){
    Surface(color = MaterialTheme.colorScheme.background, modifier = modifier.fillMaxSize()){
        LazyColumn{
            items(count = roverPhotoUiModelList.size, itemContent = {index ->
                photo(roverPhotoUiModel = roverPhotoUiModelList[index], onClick)
            })
        }
    }
}

@Composable
fun photo(
    roverPhotoUiModel: RoverPhotoUiModel,
    onClick: (roverPhotoUiModel: RoverPhotoUiModel) -> Unit
){
Card (modifier = Modifier.padding(16.dp).clickable {
    onClick
}){
    Column(modifier = Modifier.padding(16.dp)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(painter = painterResource(
                id = if (roverPhotoUiModel.isSaved) { R.drawable.baseline_save_24
                }else{
                    R.drawable.outline_save_24
                }
            ), contentDescription = "Save icon")
            Text(
                text = roverPhotoUiModel.roverName,
                modifier = Modifier.padding(16.dp))
        }


        AsyncImage(model = roverPhotoUiModel.imgSrc, contentDescription = "rover Photo", modifier = Modifier.height(300.dp))
        Text(text = stringResource(id = R.string.sol, roverPhotoUiModel.sol))
        Text(text = stringResource(id = R.string.earth_date, roverPhotoUiModel.earthDate))
        Text(text = roverPhotoUiModel.camerFullName)

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PhotoPreview(){
    photo(roverPhotoUiModel = RoverPhotoUiModel(
        id = 4,
        roverName = "Curiosity",
        imgSrc = "https://mars.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/03943/opgs/edr/fcam/FLB_747545560EDR_F1040000FHAZ00337M_.JPG", 
        sol = "34", 
        earthDate = "2021-03-05", 
        camerFullName = "Mast Camer zoom - Right",
        true
    )){

    }
}