package com.example.courseweb_student.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.courseweb_student.database.entity.Module
import com.example.courseweb_student.database.repository.ModuleRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ModuleViewModel(private val repository: ModuleRepository) : ViewModel()  {
    fun insert(module: Module) = GlobalScope.launch {
        repository.insert(module)
    }

    fun delete(module: Module) = GlobalScope.launch {
        repository.delete(module)
    }

    fun allModules(): LiveData<List<Module>> = repository.allModules()
}