package com.example.courseweb_student.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.courseweb_student.database.entity.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user : User)

    @Delete
    suspend fun delete(user: User)

    @Query("SELECT * FROM users")
    fun getAllUsers(): LiveData<List<User>>

    @Query("SELECT * FROM users WHERE username = :userName")
    fun getUserByName(userName: String): LiveData<User?>
}