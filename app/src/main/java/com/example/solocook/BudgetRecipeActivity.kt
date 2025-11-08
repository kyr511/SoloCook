package com.example.solocook

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.solocook.databinding.ActivityBudgetRecipeBinding
import com.example.solocook.model.IngredientsRequest

class BudgetRecipeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBudgetRecipeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_budget_recipe)

        binding.btnGenerate.setOnClickListener {
            val input = binding.etIngredients.text.toString()

            if (input.isEmpty()) {
                Toast.makeText(this, "금액을 입력해주세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!input.isDigitsOnly()){
                Toast.makeText(this, "숫자만 입력가능합니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val money = input.toInt()

            val intent = Intent(this, BudgetRecipeInsideActivity::class.java)
            intent.putExtra("money", money)
            startActivity(intent)
        }

        binding.back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}