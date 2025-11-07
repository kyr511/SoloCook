package com.example.solocook

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.solocook.databinding.ActivityMainBinding
import kotlin.jvm.java

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.button.setOnClickListener {  //첫번째 버튼 클릭
            val intent = Intent(this, EnterIngredientsScreen::class.java)
            startActivity(intent)
        }

        binding.button2.setOnClickListener { //두번째 버튼 클릭
            val intent = Intent(this, BudgetRecipeActivity::class.java)
            startActivity(intent)
        }
    }
}