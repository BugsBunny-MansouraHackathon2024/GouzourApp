package com.bugsbunny.gouzour.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "farmer_table")
data class Farmer(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val email: String,
    val phoneNumber: String,
    val imageUrl: String = "",
)
