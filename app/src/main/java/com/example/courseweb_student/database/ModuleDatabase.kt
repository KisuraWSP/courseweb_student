package com.example.courseweb_student.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.courseweb_student.database.dao.ModuleDao
import com.example.courseweb_student.database.entity.Module

@Database(entities = [Module::class], version = 1)
abstract class ModuleDatabase : RoomDatabase() {
    abstract fun getModuleDao() : ModuleDao

    companion object{
        @Volatile
        private var instance: ModuleDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, ModuleDatabase::class.java, "module_database.db").build()

    }
}