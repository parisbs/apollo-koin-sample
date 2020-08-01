package com.example.apollokoin.main

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

class MainViewModel(
    private val coroutineContext: CoroutineContext,
    private val allPost: AllPost
) : ViewModel() {

    private val mPosts = MutableLiveData<PostsViewState>()
    val posts: LiveData<PostsViewState>
        get() = mPosts

    fun getAllPosts(
        first: Int,
        orderBy: PostOrderBy
    ) = viewModelScope.launch(coroutineContext) {
        when (val  response = allPost(first, orderBy)) {
            is ApiResponse.Success -> mPosts.postValue(PostsViewState.Success(response.data))
            is ApiResponse.Failure -> mPosts.postValue(PostsViewState.Error(response.throwable))
        }
    }

    sealed class PostsViewState {
        class Success(val posts: List<Post>) : PostsViewState()
        object Empty : PostsViewState()
        class Error(val throwable: Throwable) : PostsViewState()
    }
}
