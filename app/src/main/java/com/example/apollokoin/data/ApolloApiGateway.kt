package com.example.apollokoin.data

import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.example.apollokoin.entities.ApiResponse
import com.example.apollokoin.entities.Comment
import com.example.apollokoin.entities.Post
import com.example.apollokoin.graphql.AllPostsQuery
import com.example.apollokoin.graphql.type.CommentOrderBy
import com.example.apollokoin.graphql.type.PostOrderBy
import com.example.apollokoin.utils.extensions.toApiModel
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class ApolloApiGateway(
    private val apolloClient: ApolloClient
) : ApiGateway {

    override suspend fun allPost(first: Int, orderBy: PostOrderBy): ApiResponse<List<Post>> =
        suspendCoroutine{ continuation ->
            apolloClient.query(
                AllPostsQuery(
                    first = first,
                    orderBy = orderBy
                )
            )
                .enqueue(object: ApolloCall.Callback<AllPostsQuery.Data>() {
                    override fun onResponse(response: Response<AllPostsQuery.Data>) {
                        if (response.hasErrors()) {
                            continuation.resume(
                                ApiResponse.Failure(
                                    Exception(response.errors?.toString())
                                )
                            )
                            return
                        }
                        response.data?.allPosts?.also { posts ->
                            posts.mapNotNull { it.toApiModel() }.apply {
                                continuation.resume(ApiResponse.Success(this))
                            }
                        } ?: continuation.resume(ApiResponse.Failure(Exception("Empty")))
                    }

                    override fun onFailure(e: ApolloException) = continuation.resume(
                        ApiResponse.Failure(e)
                    )
                })
    }

    override suspend fun getPost(
        id: String,
        commentsFirst: Int,
        commentsOrderBy: CommentOrderBy
    ): ApiResponse<Post> {
        TODO("Not yet implemented")
    }

    override suspend fun createComment(postId: String, text: String): ApiResponse<Comment> {
        TODO("Not yet implemented")
    }
}
