package com.example.courseweb_student.view

import UserViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.courseweb_student.database.repository.UserRepository

class UserViewModelFactory(private val repository: UserRepository): ViewModelProvider.NewInstanceFactory()  {
    override fun <T : ViewModel> create(modelClass: Class<T>): T{
        return UserViewModel(repository) as T
    }
}