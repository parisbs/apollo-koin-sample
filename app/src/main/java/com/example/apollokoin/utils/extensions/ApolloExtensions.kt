package com.example.apollokoin.utils.extensions

import com.example.apollokoin.entities.Post
import com.example.apollokoin.entities.User
import com.example.apollokoin.graphql.AllPostsQuery

fun AllPostsQuery.AllPost.toApiModel(): Post = Post(
    id = id,
    title = title,
    updatedAt = updatedAt.toString(),
    user = user?.toApiModel()
)

fun AllPostsQuery.User.toApiModel(): User = User(
    id = id,
    name = name
)
