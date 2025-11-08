package com.example.solocook.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.solocook.api.Api
import com.example.solocook.api.RetrofitInstance1
import com.example.solocook.api.RetrofitInstance2
import com.example.solocook.model.budget_item
import kotlinx.coroutines.launch

class BudgetViewModel : ViewModel() {
    private val retrofitInstance = RetrofitInstance2.getInstance().create(Api::class.java)

    //요리 이름
    private var mutableTitle = MutableLiveData<String>()
    val liveTitle: LiveData<String>
        get() = mutableTitle

    //요리 설ㄹ명
    private var mutableExplain = MutableLiveData<String>()
    val liveExplain: LiveData<String>
        get() = mutableExplain

    //요리재료(재료, 양)
    private var mutableBudgetList = MutableLiveData<ArrayList<budget_item>>()
    val liveBudgetList: LiveData<ArrayList<budget_item>>
        get() = mutableBudgetList

    //레시피
    private var mutableRecipe = MutableLiveData<String>()
    val liveRecipe: LiveData<String>
        get() = mutableRecipe


    fun getRecipeCard2(request: Int) = viewModelScope.launch {
        val card = retrofitInstance.getRecipeCard2(request)
        mutableTitle.value = card.title
        mutableExplain.value = card.explain
        mutableBudgetList.value = card.ingredients
        mutableRecipe.value = card.recipe

    }
}