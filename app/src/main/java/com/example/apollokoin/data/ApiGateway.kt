package com.example.apollokoin.data

import com.example.apollokoin.entities.ApiResponse
import com.example.apollokoin.entities.Comment
import com.example.apollokoin.entities.Post
import com.example.apollokoin.graphql.type.CommentOrderBy
import com.example.apollokoin.graphql.type.PostOrderBy

interface ApiGateway {

    suspend fun allPost(
        first: Int,
        orderBy: PostOrderBy
    ): ApiResponse<List<Post>>
}
