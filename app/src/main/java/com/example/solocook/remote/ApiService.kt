package com.example.solocook.remote

import com.example.solocook.model.PostDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/api/posts")
    suspend fun getPosts(): List<PostDto>

    @GET("/api/posts/{id}")
    suspend fun getPostDetail(@Path("id") id: String): PostDto
}