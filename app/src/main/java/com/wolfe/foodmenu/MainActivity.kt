package com.wolfe.foodmenu

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wolfe.foodmenu.adapter.AllMenuAdapter
import com.wolfe.foodmenu.adapter.PopularAdapter
import com.wolfe.foodmenu.adapter.RecommendedAdapter
import com.wolfe.foodmenu.data.AllMenuItem
import com.wolfe.foodmenu.data.FoodData
import com.wolfe.foodmenu.data.Popular
import com.wolfe.foodmenu.data.Recommended
import com.wolfe.foodmenu.retrofit.ApiInterface
import com.wolfe.foodmenu.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val apiInterface = RetrofitClient.retrofitInstance!!.create(ApiInterface::class.java)
        val call = apiInterface.allData
        call.enqueue(object : Callback<List<FoodData>> {
            override fun onResponse(call: Call<List<FoodData>>, response: Response<List<FoodData>>) {
                val foodDataList = response.body()!!
                getPopularData(foodDataList[0].popular)
                getRecommendedData(foodDataList[0].recommended)
                getAllMenu(foodDataList[0].allmenu)
            }

            override fun onFailure(call: Call<List<FoodData>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "S3 API not responding.", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun getPopularData(popularList: List<Popular>) {
        val popularAdapter = PopularAdapter(this, popularList)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        popular_recycler.layoutManager = layoutManager
        popular_recycler.adapter = popularAdapter
        popularAdapter.notifyDataSetChanged()
    }

    private fun getRecommendedData(recommendedList: List<Recommended>) {
        val recommendedAdapter = RecommendedAdapter(this, recommendedList)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recommended_recycler.layoutManager = layoutManager
        recommended_recycler.adapter = recommendedAdapter
        recommendedAdapter.notifyDataSetChanged()
    }

    private fun getAllMenu(allMenuItemList: List<AllMenuItem>) {
        val allMenuAdapter = AllMenuAdapter(this, allMenuItemList)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        all_menu_recycler.layoutManager = layoutManager
        all_menu_recycler.adapter = allMenuAdapter
        allMenuAdapter.notifyDataSetChanged()
    }
}