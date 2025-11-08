package com.example.solocook.community

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.solocook.R

class CommunityInsideActivity : AppCompatActivity() {

    private val vm: CommunityViewModel by viewModels { defaultViewModelProviderFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community_inside)

        val tvUser = findViewById<TextView>(R.id.user_name)
        val tvTime = findViewById<TextView>(R.id.time)
        val tvTitle = findViewById<TextView>(R.id.title)
        val tvContent = findViewById<TextView>(R.id.content)

        vm.selected.observe(this) { post ->
            if (post != null) {
                tvUser.text = post.displayName
                tvTime.text = post.timeText
                tvTitle.text = post.title
                tvContent.text = post.content
            }
        }

        val id = intent.getStringExtra("post_id") ?: return
        vm.loadDetail(id)
    }
}