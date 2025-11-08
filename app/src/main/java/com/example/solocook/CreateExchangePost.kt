package com.example.solocook

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.solocook.community.CreatePostViewModel

class CreateExchangePost : AppCompatActivity() {

    private val vm: CreatePostViewModel by viewModels { defaultViewModelProviderFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_exchange_post)

        // 뒤로가기
        findViewById<ImageView>(R.id.back).setOnClickListener { finish() }

        val etTitle = findViewById<EditText>(R.id.etTitle)
        val etDetails = findViewById<EditText>(R.id.etDetails)
        val btn = findViewById<Button>(R.id.btnGenerate)

        // 작성 버튼
        btn.setOnClickListener {
            val title = etTitle.text?.toString()?.trim().orEmpty()
            val content = etDetails.text?.toString()?.trim().orEmpty()

            if (title.isEmpty()) {
                Toast.makeText(this, "제목을 입력해 주세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (content.isEmpty()) {
                Toast.makeText(this, "내용을 입력해 주세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 요청 발사
            vm.submit(title, content)
        }

        // 성공/실패 Observe
        vm.loading.observe(this) { loading ->
            btn.isEnabled = !loading
        }

        vm.error.observe(this) { msg ->
            if (msg != null) {
                Toast.makeText(this, "업로드 실패: $msg", Toast.LENGTH_SHORT).show()
                vm.clearError()
            }
        }

        vm.created.observe(this) { created ->
            if (created != null) {
                Toast.makeText(this, "게시글이 등록되었습니다!", Toast.LENGTH_SHORT).show()
                // 필요하면 setResult 로 결과 전달하거나, 목록 갱신을 위해 finish()
                finish()
            }
        }
    }
}