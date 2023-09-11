package com.androidabcd.roverinfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.androidabcd.roverinfo.ui.theme.RoverInfoTheme
import com.androidabcd.roverinfo.ui.view.RoverList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoverInfoTheme {
                // A surface container using the 'background' color from the theme
               NavCompose()
            }
        }
    }
}
