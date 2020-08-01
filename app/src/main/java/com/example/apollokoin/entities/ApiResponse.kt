package com.example.apollokoin.entities

sealed class ApiResponse<out T> {
    class Success<T>(val data: T) : ApiResponse<T>()
    class Failure(val throwable: Throwable) : ApiResponse<Nothing>()
}
