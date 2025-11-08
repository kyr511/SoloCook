package com.example.solocook.remote

import com.example.solocook.model.PostDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.POST


data class CreatePostRequest(
    val title: String,
    val content: String
)
interface ApiService {
    @GET("/api/posts")
    suspend fun getPosts(): List<PostDto>

    @GET("/api/posts/{id}")
    suspend fun getPostDetail(@Path("id") id: String): PostDto

    @POST("/api/posts")
    suspend fun createPost(@Body req: CreatePostRequest): PostDto
}