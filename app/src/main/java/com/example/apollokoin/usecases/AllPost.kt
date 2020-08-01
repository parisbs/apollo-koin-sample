package com.example.apollokoin.usecases

import com.example.apollokoin.data.ApiGateway
import com.example.apollokoin.entities.ApiResponse
import com.example.apollokoin.entities.Post
import com.example.apollokoin.graphql.type.PostOrderBy

class AllPost(
    private val apiGateway: ApiGateway
) {
    suspend operator fun invoke(
        first: Int,
        orderBy: PostOrderBy
    ): ApiResponse<List<Post>> =
        apiGateway.allPost(first, orderBy)
}
