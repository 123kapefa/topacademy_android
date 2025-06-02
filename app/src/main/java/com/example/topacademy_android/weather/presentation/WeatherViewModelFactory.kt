package com.example.topacademy_android.weather.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.topacademy_android.weather.domain.usecase.GetWeatherUseCase

@Suppress("UNCHECKED_CAST")
class WeatherViewModelFactory(private val useCase: GetWeatherUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WeatherViewModel::class.java)) {
            return WeatherViewModel(useCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
