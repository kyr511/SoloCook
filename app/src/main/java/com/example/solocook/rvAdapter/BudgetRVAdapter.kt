package com.example.solocook.rvAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
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
        holder.foodPrice.text = prices[position].toString()
    }

    override fun getItemCount(): Int {
        return ingredients.size
    }
}