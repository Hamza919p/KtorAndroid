package com.myproject.ktor_handler

import kotlinx.serialization.Serializable

@Serializable
data class Posts(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)