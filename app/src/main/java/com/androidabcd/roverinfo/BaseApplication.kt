package com.androidabcd.roverinfo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by Ashok Kumar Srinivas on 11/09/23 around 5:00 pm
 * Youtuber on www.youtube.com/AndroidAbcd
 * Contact for any queries ashokslsk@gmail.com
 * Copyright (c) 2023 www.github.com/ashokslsk All rights reserved.
 */
@HiltAndroidApp
class BaseApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}