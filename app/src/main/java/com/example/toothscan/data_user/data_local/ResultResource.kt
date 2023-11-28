package com.example.toothscan.data_user.data_local

sealed class ResultResource<out R> private constructor() {
    data class Success<out T>(val data: T) : ResultResource<T>()
    data class Error(val error: String) : ResultResource<Nothing>()
    object Loading : ResultResource<Nothing>()
}