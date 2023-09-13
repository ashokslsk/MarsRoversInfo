package com.androidabcd.roverinfo.nav

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.navigation.NavController
import com.androidabcd.roverinfo.R
import com.androidabcd.roverinfo.nav.Destinations.Home

/**
 * Created by Ashok Kumar Srinivas on 11/09/23 around 2:15 pm
 * Youtuber on www.youtube.com/AndroidAbcd
 * Contact for any queries ashokslsk@gmail.com
 * Copyright (c) 2023 www.github.com/ashokslsk All rights reserved.
 */
object Destinations{
   const val Home = "home"
   const val Manifest = "manifest/{roverName}"
   const val Photo = "photo/{roverName}?sol={sol}"
    const val Saved = "saved"
}

class Action(navController: NavController){
    val home: ()-> Unit = {
        navController.navigate(Home)
    }

    val manifest: (roverName: String) -> Unit =
        { roverName ->
        navController.navigate("manifest/${roverName}")
    }

    val photo:(roverName: String, sol:String) -> Unit = {
        roverName, sol -> navController.navigate("photo/${roverName}?sol=${sol}ß")
    }
}

sealed class Screen(
    val route: String,
    @StringRes val resourceId: Int,
    @DrawableRes val drawableId: Int,
){
    object Home: Screen("home", R.string.rover, R.drawable.rover_svg)
    object Saved: Screen("saved", R.string.saved, R.drawable.baseline_save_24)
}