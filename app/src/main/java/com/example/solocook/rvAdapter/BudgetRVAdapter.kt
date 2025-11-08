package com.example.solocook.rvAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.solocook.R
import com.example.solocook.model.budget_item
import com.example.solocook.model.ingredients_item

class BudgetRVAdapter (private val dataset: ArrayList<budget_item>) : RecyclerView.Adapter<BudgetRVAdapter.ViewHolder>() {

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
        holder.foodName.text = dataset[position].foodName
        holder.foodPrice.text = dataset[position].foodPrice.toString()
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}