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
import com.wolfe.foodmenu.adapter.AllMenuAdapter.AllMenuViewHolder
import com.wolfe.foodmenu.data.AllMenuItem

class AllMenuAdapter(private var context: Context, private var allmMenuList: List<AllMenuItem>) : RecyclerView.Adapter<AllMenuViewHolder>() {

    override fun getItemCount(): Int {
        return allmMenuList.size
    }

    class AllMenuViewHolder(itemView: View) : ViewHolder(itemView) {
        lateinit var allMenuName : TextView
        lateinit var allMenuCharges : TextView
        lateinit var allMenuRating : TextView
        lateinit var allMenuTime : TextView
        lateinit var allMenuPrice : TextView
        lateinit var allMenuImage : ImageView

        init {
            allMenuName= itemView.findViewById(R.id.all_menu_name)
            allMenuCharges = itemView.findViewById(R.id.all_menu_delivery_charge)
            allMenuRating = itemView.findViewById(R.id.all_menu_rating)
            allMenuTime = itemView.findViewById(R.id.all_menu_deliverytime)
            allMenuPrice = itemView.findViewById(R.id.all_menu_price)
            allMenuImage = itemView.findViewById(R.id.all_menu_image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllMenuViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.allmenu_recycler_items, parent, false)
        return AllMenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: AllMenuViewHolder, position: Int) {
        holder.allMenuName.text = allmMenuList[position].name
        holder.allMenuPrice.text = "$" + allmMenuList[position].price
        holder.allMenuTime.text = allmMenuList[position].deliveryTime
        holder.allMenuRating.text = allmMenuList[position].rating
        holder.allMenuCharges.text = allmMenuList[position].deliveryCharges
        Glide.with(context).load(allmMenuList[position].imageUrl).into(holder.allMenuImage)

        holder.itemView.setOnClickListener {
            val i = Intent(context, FoodDetails::class.java)
            i.putExtra("name", allmMenuList[position].name)
            i.putExtra("price", allmMenuList[position].price)
            i.putExtra("rating", allmMenuList[position].rating)
            i.putExtra("image", allmMenuList[position].imageUrl)
            i.putExtra("note", allmMenuList[position].note)
            context.startActivity(i)
        }
    }

}