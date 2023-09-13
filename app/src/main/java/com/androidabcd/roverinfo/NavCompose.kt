package com.androidabcd.roverinfo

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.androidabcd.roverinfo.nav.Action
import com.androidabcd.roverinfo.nav.Destinations.Home
import com.androidabcd.roverinfo.nav.Destinations.Manifest
import com.androidabcd.roverinfo.nav.Destinations.Photo
import com.androidabcd.roverinfo.nav.Destinations.Saved
import com.androidabcd.roverinfo.nav.Screen
import com.androidabcd.roverinfo.ui.theme.RoverInfoTheme
import com.androidabcd.roverinfo.ui.view.ManifestScreen
import com.androidabcd.roverinfo.ui.view.PhotoScreen
import com.androidabcd.roverinfo.ui.view.RoverList
import com.androidabcd.roverinfo.ui.view.photoListSavedScreen

/**
 * Created by Ashok Kumar Srinivas on 11/09/23 around 2:20 pm
 * Youtuber on www.youtube.com/AndroidAbcd
 * Contact for any queries ashokslsk@gmail.com
 * Copyright (c) 2023 www.github.com/ashokslsk All rights reserved.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavCompose(){

    val items =  listOf(
        Screen.Home,
        Screen.Saved
    )

    val navController = rememberNavController()
    val actions = remember(navController){
        Action(navController)
    }
    RoverInfoTheme {
        Scaffold(
            bottomBar = {
                NavigationBar {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination

                    items.forEach { screen->

                        NavigationBarItem(
                        icon = {
                            Icon(
                                painter = painterResource(id = screen.drawableId),
                                contentDescription ="Bottom icon"
                            )
                        },
                            label = {
                                Text(text = stringResource(id = screen.resourceId))
                            },
                            selected = currentDestination?.hierarchy?.any {
                                if (it.route?.contains("manifest") == true || it .route?.contains("photo") == true){
                                    screen.route== "home"
                                }else {
                                    it.route == screen.route
                                }
                            } == true,
                            onClick = {
                                navController.navigate(screen.route){
                                    popUpTo(navController.graph.findStartDestination().id){
                                        saveState == true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                            )
                    }
                }
            }
        ) { innerPadding ->
            val modifier = Modifier.padding(innerPadding)
            NavHost(navController = navController, startDestination = Home) {
                composable(Home) {
                    RoverList() { roverName ->
                        actions.manifest(roverName)
                    }
                }
                composable(Manifest) { backStackEntry ->
                    ManifestScreen(
                        roverName = backStackEntry.arguments?.getString("roverName"),
                        marsRoverManifestViewModel = hiltViewModel(),
                        onClick = { roverName, sol ->
                            actions.photo(roverName, sol)
                        }
                    )
                }
                composable(Photo) { backstackentry ->
                    PhotoScreen(
                        roverName = backstackentry.arguments?.getString("roverName"),
                        sol = backstackentry.arguments?.getString("sol"),
                        marsRoverPhotoViewModel = hiltViewModel()
                    )
                }
                composable(Saved) {
                    photoListSavedScreen()
                }

            }
        }
    }
}