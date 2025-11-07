package com.example.solocook

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.solocook.databinding.ActivityCommunityBinding
import com.example.solocook.rvAdapter.CommunityRVAdapter

class CommunityActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCommunityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community)


        //Recyclerdview
        val rv : RecyclerView = binding.rv
        val items = ArrayList<String>()
        items.add("a")
        items.add("a")
        items.add("a")
        items.add("a")

        val rvAdapter = CommunityRVAdapter(items)
        rv.adapter = rvAdapter
        rv.layoutManager = LinearLayoutManager(this)

        binding.back.setOnClickListener { //Back to Home 버튼 클릭
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}