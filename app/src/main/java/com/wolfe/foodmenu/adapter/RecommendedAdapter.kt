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
import com.wolfe.foodmenu.adapter.RecommendedAdapter.RecommendedViewHolder
import com.wolfe.foodmenu.data.RecommendedItem

class RecommendedAdapter(private val context: Context, private val recommendedItemList: List<RecommendedItem>) : RecyclerView.Adapter<RecommendedViewHolder>() {
    override fun getItemCount(): Int {
        return recommendedItemList.size
    }

    class RecommendedViewHolder(itemView: View) : ViewHolder(itemView) {
        lateinit var recommendedImage: ImageView
        lateinit var recommendedName: TextView
        lateinit var recommendedRating: TextView
        lateinit var recommendedDeliveryTime: TextView
        lateinit var recommendedCharges: TextView
        lateinit var recommendedPrice: TextView

        init {
            recommendedImage = itemView.findViewById(R.id.recommended_image)
            recommendedName = itemView.findViewById(R.id.recommended_name)
            recommendedRating = itemView.findViewById(R.id.recommended_rating)
            recommendedDeliveryTime = itemView.findViewById(R.id.recommended_delivery_time)
            recommendedCharges = itemView.findViewById(R.id.delivery_type)
            recommendedCharges = itemView.findViewById(R.id.delivery_type)
            recommendedPrice = itemView.findViewById(R.id.recommended_price)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendedViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recommended_recycler_items, parent, false)
        return RecommendedViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecommendedViewHolder, position: Int) {
        holder.recommendedName.text = recommendedItemList[position].name
        holder.recommendedRating.text = recommendedItemList[position].rating
        holder.recommendedCharges.text = recommendedItemList[position].deliveryCharges
        holder.recommendedDeliveryTime.text = recommendedItemList[position].deliveryTime
        holder.recommendedPrice.text = "$" + recommendedItemList[position].price
        Glide.with(context).load(recommendedItemList[position].imageUrl).into(holder.recommendedImage)

        holder.itemView.setOnClickListener {
            val i = Intent(context, FoodDetails::class.java)
            i.putExtra("name", recommendedItemList[position].name)
            i.putExtra("price", recommendedItemList[position].price)
            i.putExtra("rating", recommendedItemList[position].rating)
            i.putExtra("image", recommendedItemList[position].imageUrl)
            i.putExtra("note", recommendedItemList[position].note)
            context.startActivity(i)
        }
    }

}