package com.example.solocook.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.solocook.api.Api
import com.example.solocook.api.RetrofitInstance1
import com.example.solocook.model.IngredientsRequest
import com.example.solocook.model.ingredients_item
import kotlinx.coroutines.launch

class ingredientViewModel : ViewModel() {

    private val retrofitInstance = RetrofitInstance1.getInstance().create(Api::class.java)

    //요리 이름
    private var mutableTitle = MutableLiveData<String>()
    val liveTitle: LiveData<String>
        get() = mutableTitle

    //요리 설ㄹ명
    private var mutableExplain = MutableLiveData<String>()
    val liveExplain: LiveData<String>
        get() = mutableExplain

    //요리재료(재료, 양)
    private var mutableIngresiantsList = MutableLiveData<ArrayList<ingredients_item>>()
    val liveIngresiantsList: LiveData<ArrayList<ingredients_item>>
        get() = mutableIngresiantsList

    //레시피
    private var mutableRecipe = MutableLiveData<String>()
    val liveRecipe: LiveData<String>
        get() = mutableRecipe

    fun getRecipeCard1(request: IngredientsRequest) = viewModelScope.launch {
        val card = retrofitInstance.getRecipeCard1(request)
        mutableTitle.value = card.title
        mutableExplain.value = card.explain
        mutableIngresiantsList.value = card.ingredients
        mutableRecipe.value = card.recipe

    }
}