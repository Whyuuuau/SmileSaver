package com.example.toothscan.model

import androidx.lifecycle.ViewModel
import com.example.toothscan.data_user.data_local.DataRepo

class MapsViewModel (
    private val repository: DataRepo
) : ViewModel(){
    fun getWithLocation(location: Int, token: String) =
        repository.getWithLocation(location, token)
}