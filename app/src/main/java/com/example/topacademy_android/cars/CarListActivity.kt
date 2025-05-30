package com.example.topacademy_android.cars

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.topacademy_android.R
import com.example.topacademy_android.databinding.ActivityCarListBinding

class CarListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCarListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()

        val mockCars = listOf(
            Car("Toyota",
                "Supra",
                1995,
                "орошее состояние, на автомобиле установлено много новых запчастей.",
                5500000,
                R.drawable.toyota_supra),
            Car("Honda",
                "NSX",
                1994,
                " Оригинальный обвес Fortune.",
                4500000,
                R.drawable.honda_nsx),
            Car("Nissan",
                "Skyline",
                1993,
                "Легендарный skyline r32.",
                2700000,
                R.drawable.nissan_skyline)
        )

        val adapter = CarAdapter(mockCars) { selectedCar ->
            val intent = Intent(this, CarDetailActivity::class.java).apply {
                putExtra("car_brand", selectedCar.brand)
                putExtra("car_model", selectedCar.model)
                putExtra("car_year", selectedCar.year)
                putExtra("car_description", selectedCar.description)
                putExtra("car_cost", selectedCar.cost)
                putExtra("car_image", selectedCar.imageResId)
            }
            startActivity(intent)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}