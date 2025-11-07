package com.example.solocook.model

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.solocook.R

//서버 응답용

data class PostDto(
    val id: String,       // 상세 조회에 필요
    val userId: String,   // 익명 매핑용 키(백엔드에서 고정값 내려주길 권장)
    val time: String,     // "yyyy-MM-dd HH:mm" 또는 epoch 등
    val title: String,
    val content: String
)