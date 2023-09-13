package com.androidabcd.roverinfo.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Created by Ashok Kumar Srinivas on 13/09/23 around 1:31 pm
 * Youtuber on www.youtube.com/AndroidAbcd
 * Contact for any queries ashokslsk@gmail.com
 * Copyright (c) 2023 www.github.com/ashokslsk All rights reserved.
 */
@Database(
    entities = [MarsRoverSavedLocalModel::class],
    version = 1,
    exportSchema = false
)
abstract class MarsRoverSavedDatabase: RoomDatabase() {
    abstract fun marsRoverSavedPhotoDao(): MarsRoverSavedPhotoDao

    companion object{
        @Volatile
        private var INSTANCE: MarsRoverSavedDatabase? = null

        fun getInstance(context: Context): MarsRoverSavedDatabase =
            INSTANCE?: synchronized(this){
                INSTANCE?: buildDatabase(context).also{
                    INSTANCE = it
                }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context,
                MarsRoverSavedDatabase::class.java, "marsRover.db")
                .fallbackToDestructiveMigration()
                .build()
    }
}