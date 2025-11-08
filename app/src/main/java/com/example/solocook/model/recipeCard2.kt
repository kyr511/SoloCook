package com.example.solocook.model

data class recipeCard2  ( //Bueget Recipe
    val title : String,
    val explain : String,
    val ingredients : ArrayList<String>,
    val ingredients_price : ArrayList<Int>,
    val recipe: String
)