package com.bugsbunny.gouzour.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bugsbunny.gouzour.model.Farmer

@Database(entities = [Farmer::class], version = 2, exportSchema = false)
abstract class FarmerDatabase : RoomDatabase() {
    abstract fun farmerDao(): FarmerDao
}