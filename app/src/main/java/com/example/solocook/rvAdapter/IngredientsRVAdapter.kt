package com.example.solocook.rvAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.solocook.R
import com.example.solocook.model.ingredients_item

class IngredientsRVAdapter (private val dataset: ArrayList<ingredients_item>) : RecyclerView.Adapter<IngredientsRVAdapter.ViewHolder>() {

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val foodName: TextView
        val foodAmount: TextView
        init {
            foodName = itemView.findViewById(R.id.foodName)
            foodAmount = itemView.findViewById(R.id.foodAmount)
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.ingredients_item, parent, false)
        return ViewHolder(v)


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.foodName.text = dataset[position].foodName
        holder.foodAmount.text = dataset[position].foodAmount
    }

    override fun getItemCount(): Int {
        return dataset.size
    }


}