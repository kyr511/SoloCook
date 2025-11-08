package com.example.solocook.rvAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.solocook.R

class BudgetRVAdapter (
    private val ingredients: ArrayList<String>,
    private val prices: ArrayList<Int>
) : RecyclerView.Adapter<BudgetRVAdapter.ViewHolder>() {

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val foodName: TextView
        val foodPrice: TextView
        init {
            foodName = itemView.findViewById(R.id.foodName)
            foodPrice = itemView.findViewById(R.id.foodPrice)
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.budget_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.foodName.text = ingredients[position]
        if (position < prices.size) {
            // 가격 데이터가 있으면: 가격을 표시
            holder.foodPrice.text = prices[position].toString()
        } else {
            // 가격 데이터가 없으면 빈 문자열
            holder.foodPrice.text = "가격 정보 없음"
        }
    }

    override fun getItemCount(): Int {
        return ingredients.size
    }
}