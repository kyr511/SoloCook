package com.example.solocook

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.solocook.databinding.ActivityEnterIngredientsInsideBinding
import com.example.solocook.model.IngredientsRequest
import com.example.solocook.rvAdapter.IngredientsRVAdapter
import com.example.solocook.viewModel.ingredientViewModel

class EnterIngredientsInside : AppCompatActivity() {

    private lateinit var binding: ActivityEnterIngredientsInsideBinding
    private lateinit var viewModel: ingredientViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_enter_ingredients_inside)

        val ingredients = intent.getStringArrayListExtra("ingredients_list")
        val request = IngredientsRequest(ingredients!!)

        //레시피 화면에 띄우기
        viewModel = ViewModelProvider(this).get(ingredientViewModel::class.java)
        viewModel.getRecipeCard1(request)

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

        viewModel.liveIngresiantsList.observe(this, Observer {
            val ingredientAdapter = IngredientsRVAdapter(it as ArrayList<String>)
            rv.adapter = ingredientAdapter
            rv.layoutManager = LinearLayoutManager(this)
        })


        //버튼제어
        binding.tryBtn.setOnClickListener { //try again 버튼 클릭
            viewModel.getRecipeCard1(request)
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