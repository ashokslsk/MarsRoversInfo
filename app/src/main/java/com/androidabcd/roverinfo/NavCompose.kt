package com.androidabcd.roverinfo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.androidabcd.roverinfo.nav.Action
import com.androidabcd.roverinfo.nav.Destinations.Home
import com.androidabcd.roverinfo.nav.Destinations.Manifest
import com.androidabcd.roverinfo.ui.theme.RoverInfoTheme
import com.androidabcd.roverinfo.ui.view.ManifestScreen
import com.androidabcd.roverinfo.ui.view.RoverList

/**
 * Created by Ashok Kumar Srinivas on 11/09/23 around 2:20 pm
 * Youtuber on www.youtube.com/AndroidAbcd
 * Contact for any queries ashokslsk@gmail.com
 * Copyright (c) 2023 www.github.com/ashokslsk All rights reserved.
 */

@Composable
fun NavCompose(){
    val navController = rememberNavController()
    val actions = remember(navController){
        Action(navController)
    }
    RoverInfoTheme {
        NavHost(navController = navController, startDestination = Home){
            composable(Home){
                RoverList(){
                    roverName ->
                    actions.manifest(roverName)
                }
            }
            composable(Manifest){ backStackEntry ->
                ManifestScreen(
                    roverName = backStackEntry.arguments?.getString("roverName")
                )
            }
        }
    }
}