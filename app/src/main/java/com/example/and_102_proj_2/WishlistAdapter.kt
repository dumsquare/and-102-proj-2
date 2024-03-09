package com.example.and_102_proj_2;

import android.view.LayoutInflater
import android.view.View;
import android.view.ViewGroup
import android.widget.TextView


import androidx.recyclerview.widget.RecyclerView;

class WishlistAdapter(private val listItems: List<ListItem>) : RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val itemNameTextView: TextView
        val priceTextView: TextView
        val storeTextView: TextView

    init {
        itemNameTextView = itemView.findViewById(R.id.itemName)
        priceTextView = itemView.findViewById(R.id.price)
        storeTextView = itemView.findViewById(R.id.store)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val listItemView = inflater.inflate(R.layout.wishlist, parent, false)
        return ViewHolder(listItemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listItem = listItems.get(position)
        holder.itemNameTextView.text = listItem.itemName
        holder.priceTextView.text = listItem.price
        holder.storeTextView.text = listItem.store

    }

    override fun getItemCount(): Int {
        return listItems.size
    }
}
