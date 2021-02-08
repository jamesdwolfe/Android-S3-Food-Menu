package com.wolfe.foodmenu.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.wolfe.foodmenu.FoodDetails
import com.wolfe.foodmenu.R
import com.wolfe.foodmenu.adapter.PopularAdapter.PopularViewHolder
import com.wolfe.foodmenu.data.PopularItem

class PopularAdapter(private val context: Context, private val popularItemList: List<PopularItem>) : RecyclerView.Adapter<PopularViewHolder>() {
    override fun getItemCount(): Int {
        return popularItemList.size
    }

    class PopularViewHolder(itemView: View) : ViewHolder(itemView) {
        lateinit var popularImage: ImageView
        lateinit var popularName: TextView

        init {
            popularName = itemView.findViewById(R.id.popular_menu_name)
            popularImage = itemView.findViewById(R.id.popular_menu_image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.popular_recycler_items, parent, false)
        return PopularViewHolder(view)
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        holder.popularName.text = popularItemList[position].name
        Glide.with(context).load(popularItemList[position].imageUrl).into(holder.popularImage)

        holder.itemView.setOnClickListener {
            val i = Intent(context, FoodDetails::class.java)
            i.putExtra("name", popularItemList[position].name)
            i.putExtra("price", popularItemList[position].price)
            i.putExtra("rating", popularItemList[position].rating)
            i.putExtra("image", popularItemList[position].imageUrl)
            i.putExtra("note", popularItemList[position].note)
            context.startActivity(i)
        }
    }

}