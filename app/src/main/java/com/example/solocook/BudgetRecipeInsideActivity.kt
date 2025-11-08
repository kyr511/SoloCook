package com.example.solocook

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.solocook.databinding.ActivityBudgetRecipeInsideBinding
import com.example.solocook.rvAdapter.BudgetRVAdapter
import com.example.solocook.rvAdapter.IngredientsRVAdapter
import com.example.solocook.viewModel.BudgetViewModel
import com.example.solocook.viewModel.ingredientViewModel

class BudgetRecipeInsideActivity : AppCompatActivity() {

    private lateinit var binding : ActivityBudgetRecipeInsideBinding
    private lateinit var viewModel: BudgetViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_budget_recipe_inside)

        val request = intent.getIntExtra("money", 0)

        //레시피 화면에 띄우기
        viewModel = ViewModelProvider(this).get(BudgetViewModel::class.java)
        viewModel.getRecipeCard2(request)

        val title = binding.title
        val explain = binding.explain
        val recipe = binding.recipeText

        viewModel.liveTitle.observe(this, Observer{
            title.text = it.toString()
        })

        viewModel.liveTitle.observe(this, Observer{
            explain.text = it.toString()
        })

        viewModel.liveTitle.observe(this, Observer{
            recipe.text = it.toString()
        })


        //Recyclerdview
        val rv = binding.rv
        rv.layoutManager = LinearLayoutManager(this)

        fun updateAdapter() {
            val ingredients = viewModel.liveIngredientsList.value
            val prices = viewModel.livePriceList.value
            if (ingredients != null && prices != null && ingredients.size == prices.size) {
                val budgetAdapter = BudgetRVAdapter(ingredients, prices) // Adapter가 두 리스트를 받도록 설계됨
                rv.adapter = budgetAdapter

                // 총합 계산
                val total = prices.sum()
                binding.total.text = total.toString()
            }
        }

        viewModel.liveIngredientsList.observe(this) { updateAdapter() }
        viewModel.livePriceList.observe(this) { updateAdapter() }


        //버큰클릭
        binding.tryBtn.setOnClickListener { //try again 버튼 클릭
            viewModel.getRecipeCard2(request)
        }

        binding.backBtn.setOnClickListener { //Back to Home 버튼 클릭
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }
}