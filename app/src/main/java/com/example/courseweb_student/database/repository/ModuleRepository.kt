package com.example.courseweb_student.database.repository

import com.example.courseweb_student.database.ModuleDatabase
import com.example.courseweb_student.database.entity.Module

class ModuleRepository(private val db: ModuleDatabase) {
    suspend fun insert(module: Module) = db.getModuleDao().insert(module)
    suspend fun delete(module: Module) = db.getModuleDao().delete(module)

    fun allModules() = db.getModuleDao().getAllModules()
}