package com.example.raindrop.Activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.raindrop.Adapter.HourlyAdapter
import com.example.raindrop.Adapter.OtherCityAdapter
import com.example.raindrop.Model.CityModel
import com.example.raindrop.Model.HourlyModel
import com.example.raindrop.R
import com.example.raindrop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.chipNavigator.setItemSelected(R.id.home,true)

        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        initRecyclerviewHourly()
        initRecyclerOtherCity()
    }

    private fun initRecyclerOtherCity() {
        val items:ArrayList<CityModel> =ArrayList()

        items.add(CityModel("Amman", 28, "sunny", 20, 40, 10))
        items.add(CityModel("Zarqa", 30, "sunny", 22, 35, 5))
        items.add(CityModel("Irbid", 26, "cloudy_2", 18, 45, 15))
        items.add(CityModel("Mafraq", 29, "sunny", 25, 30, 8))
        items.add(CityModel("Jerash", 24, "cloudy", 15, 50, 20))
        items.add(CityModel("Ajloun", 23, "cloudy", 14, 55, 25))
        items.add(CityModel("Balqa", 27, "cloudy_2", 19, 42, 12))
        items.add(CityModel("Karak", 25, "sunny", 17, 38, 10))
        items.add(CityModel("Tafilah", 24, "cloudy_2", 16, 43, 18))
        items.add(CityModel("Ma'an", 32, "sunny", 28, 25, 3))
        items.add(CityModel("Aqaba", 35, "sunny", 30, 20, 2))
        items.add(CityModel("Madaba", 27, "cloudy_2", 20, 40, 10))
        items.add(CityModel("Anjara", 23, "cloudy", 14, 52, 22))
        items.add(CityModel("Ramtha", 26, "sunny", 19, 37, 9))
        items.add(CityModel("Sweileh", 28, "cloudy_2", 21, 39, 11))

        binding.view2.layoutManager= LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        binding.view2.adapter= OtherCityAdapter(items)
    }

    private fun initRecyclerviewHourly() {
        val items: ArrayList<HourlyModel> =ArrayList()

        items.add(HourlyModel("9 pm",28,"cloudy"))
        items.add(HourlyModel("10 pm",29,"sunny"))
        items.add(HourlyModel("11 pm",30,"windy"))
        items.add(HourlyModel("12 pm",31,"cloudy_2"))
        items.add(HourlyModel("1 am",10,"snowy"))

        binding.view1.setLayoutManager(LinearLayoutManager
            (this, LinearLayoutManager.HORIZONTAL,false))
        binding.view1.adapter= HourlyAdapter(items)

    }
}