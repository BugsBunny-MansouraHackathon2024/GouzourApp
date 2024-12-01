package com.bugsbunny.gouzour.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bugsbunny.gouzour.model.Farmer


@Dao
interface FarmerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(farmer: Farmer)

    @Query("SELECT * FROM farmer_table WHERE email = :email LIMIT 1")
    suspend fun getUserByEmail(email: String): Farmer?

    @Query("UPDATE farmer_table SET name = :name, email = :email ,imageUrl = :imageUrl, phoneNumber = :phoneNumber WHERE id = :id")
    suspend fun updateUserById(
        id: Int,
        name: String,
        email: String,
        imageUrl: String,
        phoneNumber: String,
    )

    @Query("DELETE FROM farmer_table WHERE id = :id")
    suspend fun deleteUserById(id: Int)

    @Query("SELECT EXISTS(SELECT 1 FROM farmer_table WHERE email = :email)")
    suspend fun doesEmailExist(email: String): Boolean

}