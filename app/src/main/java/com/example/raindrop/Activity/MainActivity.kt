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