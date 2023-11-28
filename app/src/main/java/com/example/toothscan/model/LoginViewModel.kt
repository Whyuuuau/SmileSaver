package com.example.toothscan.model

import androidx.lifecycle.ViewModel
import com.example.toothscan.data_user.data_local.DataRepo

class LoginViewModel(
    private val repository: DataRepo

) : ViewModel(){
    fun login(email: String, pass: String) = repository.login(email, pass)
}