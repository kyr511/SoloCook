package com.example.solocook.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance1 {//Enter ingrediefnts

    val URL = "https://79fzgkgm66.execute-api.us-east-1.amazonaws.com/" //서버 주소(백엔드)

    val client = Retrofit
        .Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getInstance() : Retrofit {
        return client
    }
}