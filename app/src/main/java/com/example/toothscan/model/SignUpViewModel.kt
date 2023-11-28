package com.example.toothscan.model

import androidx.lifecycle.ViewModel
import com.example.toothscan.data_user.data_local.DataRepo

class SignUpViewModel(
    private val repository: DataRepo
) : ViewModel(){
    fun register(name: String, email: String, pass: String) = repository.register(name, email, pass)
}