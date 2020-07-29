package com.example.apollokoin.entities

import java.util.*

data class Post(
    val id: String = "",
    val title: String = "",
    val text: String = "",
    val updatedAt: String = "",
    val user: User? = null,
    val comments: List<Comment>? = null
) {
}