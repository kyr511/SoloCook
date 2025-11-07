package com.example.solocook

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.solocook.databinding.ActivityBudgetRecipeInsideBinding
import com.example.solocook.rvAdapter.BudgetRVAdapter

class BudgetRecipeInsideActivity : AppCompatActivity() {

    private lateinit var binding : ActivityBudgetRecipeInsideBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_budget_recipe_inside)

        //Recyclerdview
        val rv : RecyclerView = binding.rv
        val items = ArrayList<String>()
        items.add("a")
        items.add("a")
        items.add("a")
        items.add("a")

        val rvAdapter = BudgetRVAdapter(items)
        rv.adapter = rvAdapter
        rv.layoutManager = LinearLayoutManager(this)

        //버큰클릭
        binding.tryBtn.setOnClickListener { //try again 버튼 클릭

        }

        binding.backBtn.setOnClickListener { //Back to Home 버튼 클릭
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }
}