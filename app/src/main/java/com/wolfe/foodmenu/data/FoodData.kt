package com.wolfe.foodmenu.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class FoodData {
    @SerializedName("popular")
    @Expose
    var popular: List<PopularItem> = emptyList()

    @SerializedName("recommended")
    @Expose
    var recommended: List<RecommendedItem> = emptyList()

    @SerializedName("allmenu")
    @Expose
    var allmenu: List<AllMenuItem> = emptyList()
}