package com.bugsbunny.gouzour.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "farmer_table")
data class Product(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val color: String,
    val season: String,
    val imageUrl: String = "",
)
