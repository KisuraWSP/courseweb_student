package com.example.courseweb_student.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.courseweb_student.database.entity.Module

@Dao
interface ModuleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(module: Module)

    @Delete
    suspend fun delete(module: Module)

    @Query("SELECT * FROM modules")
    fun getAllModuless(): LiveData<List<Module>>
}