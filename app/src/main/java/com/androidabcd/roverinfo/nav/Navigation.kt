package com.androidabcd.roverinfo.nav

import androidx.navigation.NavController
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
}

class Action(navController: NavController){
    val home: ()-> Unit = {
        navController.navigate(Home)
    }

    val manifest: (roverName: String) -> Unit =
        { roverName ->
        navController.navigate("manifest/${roverName}")
    }
}