package com.example.apollokoin.post

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apollokoin.entities.ApiResponse
import com.example.apollokoin.entities.Post
import com.example.apollokoin.graphql.type.PostOrderBy
import com.example.apollokoin.usecases.AllPost
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class PostViewModel(
) : ViewModel() {
}
