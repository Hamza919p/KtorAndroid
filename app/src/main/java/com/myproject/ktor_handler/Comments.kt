package com.myproject.ktor_handler

import kotlinx.serialization.Serializable

@Serializable
data class Comments(
    val body: String,
    val email: String,
    val id: Int,
    val name: String,
    val postId: Int
)