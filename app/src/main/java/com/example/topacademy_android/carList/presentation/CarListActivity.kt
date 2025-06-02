package com.example.topacademy_android.carList.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.topacademy_android.carList.data.repository.CarRepositoryImpl
import com.example.topacademy_android.carList.domain.usecase.GetCarsUseCase
import com.example.topacademy_android.carList.presentation.adapter.CarAdapter
import com.example.topacademy_android.carList.presentation.viewmodel.CarViewModel
import com.example.topacademy_android.databinding.ActivityCarListBinding

class CarListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCarListBinding
    private lateinit var viewModel: CarViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val repository = CarRepositoryImpl()
        val useCase = GetCarsUseCase(repository)
        viewModel = CarViewModel(useCase)

        setupToolbar()

        viewModel.cars.observe(this) { carList ->
            val adapter = CarAdapter(carList) { selectedCar ->
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

        viewModel.loadCars()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}