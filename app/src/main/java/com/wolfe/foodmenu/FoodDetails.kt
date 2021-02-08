package com.wolfe.foodmenu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_food_details.*

class FoodDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_details)

        Glide.with(applicationContext).load(intent.getStringExtra("image")).into(mainImage)
        name.text = intent.getStringExtra("name")
        price.text = '$' + intent.getStringExtra("price")!!
        rating.text = intent.getStringExtra("rating")
        ratingBar.rating = intent.getStringExtra("rating")!!.toFloat()

        backButton.setOnClickListener { onBackPressed() }

    }
}