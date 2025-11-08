package com.example.solocook.model

data class recipeCard2  ( //Bueget Recipe
    val title : String,
    val explain : String,
    val ingredients : ArrayList<budget_item>,
    val recipe: String
)