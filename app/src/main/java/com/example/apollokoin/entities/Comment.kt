package com.example.apollokoin.entities

import java.util.*

data class Comment(
    val id: String = "",
    val text: String = "",
    val createdAt: Date? = null,
val  updatedAt: Date? = null,
    val user: User? = null
) {
}
