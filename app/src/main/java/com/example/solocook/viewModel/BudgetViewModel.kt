package com.example.solocook.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.solocook.api.Api
import com.example.solocook.api.RetrofitInstance1
import com.example.solocook.api.RetrofitInstance2
import kotlinx.coroutines.launch
import retrofit2.HttpException

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

    //요리재료 리스트
    private var mutableIngredientsList = MutableLiveData<ArrayList<String>>()
    val liveIngredientsList: LiveData<ArrayList<String>>
        get() = mutableIngredientsList

    //요리재료가격리스트
    private var mutablePriceList = MutableLiveData<ArrayList<Int>>()
    val livePriceList: LiveData<ArrayList<Int>>
        get() = mutablePriceList



    //레시피
    private var mutableRecipe = MutableLiveData<String>()
    val liveRecipe: LiveData<String>
        get() = mutableRecipe


    fun getRecipeCard2(request: Int) =
        viewModelScope.launch {
            try {
                val card = retrofitInstance.getRecipeCard2(request)
                mutableTitle.value = card.title
                mutableExplain.value = card.explain
                mutableIngredientsList.value = card.ingredients
                mutableRecipe.value = card.recipe
            } catch (e: HttpException) {
                // HTTP 에러가 발생했을 때 (예: 404, 500 등)
                // 에러를 로그로 남기거나 사용자에게 알림
                Log.e("BudgetViewModel", "HttpException: ${e.message()}")
                // TODO: 사용자에게 "서버 오류가 발생했습니다." 같은 토스트 메시지를 보여주는 로직 추가

            } catch (e: Exception) {
                // 그 외 모든 에러 (인터넷 연결 끊김 등)
                Log.e("BudgetViewModel", "Exception: ${e.localizedMessage}")
                // TODO: 사용자에게 "네트워크 연결을 확인해주세요." 같은 토스트 메시지를 보여주는 로직 추가
            }
    }
}