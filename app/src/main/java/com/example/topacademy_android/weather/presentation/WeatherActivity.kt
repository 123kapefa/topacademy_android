package com.example.topacademy_android.weather.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.topacademy_android.databinding.ActivityWeatherBinding
import com.example.topacademy_android.weather.data.remote.api.RetrofitInstance
import com.example.topacademy_android.weather.data.repository.WeatherRepositoryImpl
import com.example.topacademy_android.weather.domain.usecase.GetWeatherUseCase
import com.example.topacademy_android.weather.presentation.adapter.WeatherAdapter

class WeatherActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWeatherBinding
    private lateinit var viewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val api = RetrofitInstance.api
        val repository = WeatherRepositoryImpl(api)
        val useCase = GetWeatherUseCase(repository)

        val factory = WeatherViewModelFactory(useCase)
        viewModel = ViewModelProvider(this, factory)[WeatherViewModel::class.java]

        val adapter = WeatherAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.forecast.observe(this) { forecast ->
            adapter.submitList(forecast)
        }

        viewModel.loadForecast(55.7558, 37.6173)

        setupToolbar()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}
