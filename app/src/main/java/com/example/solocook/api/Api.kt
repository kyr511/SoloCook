package com.example.solocook.api

import com.example.solocook.model.IngredientsRequest
import com.example.solocook.model.budget_item
import com.example.solocook.model.recipeCard1
import com.example.solocook.model.recipeCard2
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {

    @POST("dev")
    suspend fun getRecipeCard1(
        @Body request: IngredientsRequest
    ) : recipeCard1

    @POST("dev")
    suspend fun getRecipeCard2(
        @Body request: Int
    ) : recipeCard2


}