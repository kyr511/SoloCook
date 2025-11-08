package com.example.solocook.repository

import android.content.Context
import com.example.solocook.model.PostDto
import com.example.solocook.model.PostUi
import com.example.solocook.remote.CreatePostRequest
import com.example.solocook.remote.RetrofitClient
import com.example.solocook.util.DummyNameMapper
import kotlin.collections.map

class CommunityRepository (
    private val appContext: Context   // Context 받기
){
    private val api = RetrofitClient.api

    /** 게시글 목록 불러오기 */
    suspend fun getPosts(): List<PostUi> {
        val dtoList: List<PostDto> = api.getPosts()
        return dtoList.map { dto ->
            PostUi(
                id = dto.id,
                displayName = DummyNameMapper.getDisplayName(appContext, dto.userId),
                title = dto.title,
                content = dto.content,
                timeText = dto.time
            )
        }
    }

    /** 게시글 상세 불러오기 */
    suspend fun getPostDetail(id: String): PostUi {
        val dto = api.getPostDetail(id)
        return PostUi(
            id = dto.id,
            displayName = DummyNameMapper.getDisplayName(appContext, dto.userId),
            title = dto.title,
            content = dto.content,
            timeText = dto.time
        )
    }

    suspend fun createPost(title: String, content: String): PostUi {
        val dto = api.createPost(CreatePostRequest(title = title, content = content))
        return PostUi(
            id = dto.id,
            displayName = DummyNameMapper.getDisplayName(appContext, dto.userId),
            title = dto.title,
            content = dto.content,
            timeText = dto.time
        )
    }
}
