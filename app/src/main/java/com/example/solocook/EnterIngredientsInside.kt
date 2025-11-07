package com.example.solocook

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.solocook.databinding.ActivityEnterIngredientsInsideBinding
import com.example.solocook.rvAdapter.CommunityRVAdapter

class EnterIngredientsInside : AppCompatActivity() {

    private lateinit var binding: ActivityEnterIngredientsInsideBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_enter_ingredients_inside)

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


        binding.tryBtn.setOnClickListener { //try again 버튼 클릭

        }

        binding.backBtn.setOnClickListener { //Back to Home 버튼 클릭
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}