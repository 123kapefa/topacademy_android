package com.example.topacademy_android.carList.presentation

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.topacademy_android.R
import com.example.topacademy_android.databinding.ActivityCarDetailBinding

class CarDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCarDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val brand = intent.getStringExtra("car_brand")
        val model = intent.getStringExtra("car_model")
        val year = intent.getIntExtra("car_year", 0)
        val description = intent.getStringExtra("car_description")
        val cost = intent.getIntExtra("car_cost", 0)
        val imageResId = intent.getIntExtra("car_image", 0)

        val ivCar = findViewById<ImageView>(R.id.ivCarDetail)
        val tvTitle = findViewById<TextView>(R.id.tvTitle)
        val tvYear = findViewById<TextView>(R.id.tvYear)
        val tvDesc = findViewById<TextView>(R.id.tvDescription)
        val tvCost = findViewById<TextView>(R.id.tvCost)

        tvTitle.text = "$brand $model"
        tvYear.text = "Год выпуска: $year"
        tvDesc.text = description
        tvCost.text = "Цена: $cost ₽"
        ivCar.setImageResource(imageResId)

        setupToolbar(tvTitle.text.toString())
    }

    private fun setupToolbar(title: String) {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "$title"
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}