package com.example.solocook.community

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.solocook.CommunityInsideActivity
import com.example.solocook.R

class CommunityActivity : AppCompatActivity() {

    private val vm: CommunityViewModel by viewModels()
    private lateinit var adapter: CommunityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community)

        // 뒤로가기 버튼
        findViewById<ImageView>(R.id.back).setOnClickListener {
            finish()
        }

        // 1) RecyclerView 설정
        val rv = findViewById<RecyclerView>(R.id.rv)
        rv.layoutManager = LinearLayoutManager(this)

        //2) Adapter 생성 (게시글 클릭 → 상세 페이지 이동)
        adapter = CommunityAdapter { item ->
            val intent = Intent(this, CommunityInsideActivity::class.java)
            intent.putExtra("post_id", item.id)
            startActivity(intent)
        }

        rv.adapter = adapter

        // 3) ViewModel에 게시글 리스트 Observe
        vm.posts.observe(this) { list ->
            if (list != null) adapter.submit(list)
        }

        //4) 게시글 목록 요청
        vm.loadList()
    }
}