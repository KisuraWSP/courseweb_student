package com.example.courseweb_student.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.courseweb_student.database.dao.UserDao
import com.example.courseweb_student.database.entity.User

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase(){
    abstract fun getUserDao() : UserDao

    companion object{
        @Volatile
        private var instance: UserDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, UserDatabase::class.java, "user_database.db").build()

    }
}