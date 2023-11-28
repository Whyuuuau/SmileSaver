package com.example.toothscan.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.toothscan.data_user.data_local.DataRepo
import com.example.toothscan.data_user.api_manager.api_response.ListStoryItem

class HomeViewModel(
    private val repository: DataRepo
) : ViewModel() {
    fun getStory(token: String): LiveData<PagingData<ListStoryItem>> =
        repository.getStories(token).cachedIn(viewModelScope)
}



