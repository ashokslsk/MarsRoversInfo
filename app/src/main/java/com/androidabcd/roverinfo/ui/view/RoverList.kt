package com.androidabcd.roverinfo.ui.view

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androidabcd.roverinfo.R
import com.androidabcd.roverinfo.domain.model.roverUiModelList
import java.util.Date

/**
 * Created by Ashok Kumar Srinivas on 11/09/23 around 1:11 pm
 * Youtuber on www.youtube.com/AndroidAbcd
 * Contact for any queries ashokslsk@gmail.com
 * Copyright (c) 2023 www.github.com/ashokslsk All rights reserved.
 */

@Composable
fun RoverList(
    onClick: (roverName: String) -> Unit
){
    Surface(color = MaterialTheme.colorScheme.background, modifier = Modifier.fillMaxSize()) {
        LazyColumn{
            items(
                count = roverUiModelList.size,
                itemContent = { index ->
                Rover(
                    name = roverUiModelList[index].name,
                    img = roverUiModelList[index].img,
                    landingDate =roverUiModelList[index].landingDate,
                    diatanceTravelled = roverUiModelList[index].distance,
                    onClick = onClick
                )
            })
        }
    }
}

@Preview
@Composable
fun RoverPreview(){
//    Rover("Perserverance", R.drawable.perseverance, "18 February 2021", "12.56 km"){
//
//    }
}
@Composable
fun Rover(
    name: String,
    img: Int,
    landingDate: String,
    diatanceTravelled: String,
    onClick: (roverName: String) -> Unit
){
    Card(
        modifier = Modifier
            .padding(16.dp)
            .clickable { onClick(name)
            }) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = name,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
            Image(painter = painterResource(id = img), contentDescription = null)
            Text(text = "Credit : NASA/JPL", fontSize = 8.sp)
            Text(text = "Landing Date : $landingDate", fontSize = 12.sp)
            Text(text = "Distance Travelled : $diatanceTravelled", fontSize = 12.sp)
        }
    }
}