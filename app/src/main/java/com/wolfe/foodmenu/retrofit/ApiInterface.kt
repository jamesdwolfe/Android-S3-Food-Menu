package com.wolfe.foodmenu.retrofit

import com.wolfe.foodmenu.data.FoodData
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @get:GET("menudata.json")
    val allData: Call<List<FoodData>>
}