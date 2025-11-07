package com.example.solocook

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.solocook.databinding.ActivityCommunityBinding
import com.example.solocook.databinding.ActivityEnterIngredientsScreenBinding

class EnterIngredientsScreen : AppCompatActivity() {

    private lateinit var binding: ActivityEnterIngredientsScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_enter_ingredients_screen)

        binding.btnGenerate.setOnClickListener {
            val intent = Intent(this, EnterIngredientsInside::class.java)
        }
    }
}