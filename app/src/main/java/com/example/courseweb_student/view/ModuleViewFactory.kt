package com.example.courseweb_student.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.courseweb_student.database.repository.ModuleRepository

class ModuleViewFactory(private val repository: ModuleRepository): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T{
        return ModuleViewModel(repository) as T
    }
}