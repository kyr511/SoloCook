package com.example.solocook

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.solocook.databinding.ActivityCommunityBinding
import com.example.solocook.databinding.ActivityEnterIngredientsScreenBinding
import com.example.solocook.model.IngredientsRequest

class EnterIngredientsScreen : AppCompatActivity() {

    private lateinit var binding: ActivityEnterIngredientsScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_enter_ingredients_screen)


        binding.btnGenerate.setOnClickListener {
            val input = binding.etIngredients.text.toString()

            if (input.isEmpty()) {
                Toast.makeText(this, "재료를 1개 이상 입력해주세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val ingredientsList = input.split(',').map { it.trim() }.filter { it.isNotEmpty() }

            val request = IngredientsRequest(ingredientsList)

            val intent = Intent(this, EnterIngredientsInside::class.java)
            intent.putStringArrayListExtra("ingredients_list", ArrayList(ingredientsList))
            startActivity(intent)
        }

        binding.back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}