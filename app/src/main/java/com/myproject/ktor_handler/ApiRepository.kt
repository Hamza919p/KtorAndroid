package com.myproject.ktor_handler

import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.url

class ApiRepository {

    suspend fun getPosts() : List<Posts> =
        KtorClient.httpClient.get("https://jsonplaceholder.typicode.com/posts")

    suspend fun getPostById(id: String): Comments =
        KtorClient.httpClient.get {

            //https://jsonplaceholder.typicode.com/comments?postId=1

            url("https://jsonplaceholder.typicode.com/comments")
            parameter("postId", id)

        }

    suspend fun postPost(post: Posts) : Posts =
        KtorClient.httpClient.post<Posts> {
            url("https://jsonplaceholder.typicode.com/posts")
            body = post
        }
}