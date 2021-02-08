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
import com.wolfe.foodmenu.data.Popular

class PopularAdapter(private val context: Context, private val popularList: List<Popular>) : RecyclerView.Adapter<PopularViewHolder>() {
    override fun getItemCount(): Int {
        return popularList.size
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
        holder.popularName.text = popularList[position].name
        Glide.with(context).load(popularList[position].imageUrl).into(holder.popularImage)

        holder.itemView.setOnClickListener {
            val i = Intent(context, FoodDetails::class.java)
            i.putExtra("name", popularList[position].name)
            i.putExtra("price", popularList[position].price)
            i.putExtra("rating", popularList[position].rating)
            i.putExtra("image", popularList[position].imageUrl)
            i.putExtra("note", popularList[position].note)
            context.startActivity(i)
        }
    }

}