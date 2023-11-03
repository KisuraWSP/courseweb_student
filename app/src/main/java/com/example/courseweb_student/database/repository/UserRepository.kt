package com.example.courseweb_student.database.repository

import androidx.lifecycle.LiveData
import com.example.courseweb_student.database.UserDatabase
import com.example.courseweb_student.database.entity.User

class UserRepository(private val db: UserDatabase) {
    suspend fun insert(user : User) = db.getUserDao().insert(user)
    suspend fun delete(user : User) = db.getUserDao().delete(user)

    fun allUsers() = db.getUserDao().getAllUsers()
    fun getUserByName(userName: String): LiveData<User?> {
        return db.getUserDao().getUserByName(userName)
    }
}