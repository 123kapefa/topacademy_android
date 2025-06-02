package com.example.topacademy_android.weather.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.topacademy_android.weather.domain.model.ForecastItem
import com.example.topacademy_android.weather.domain.usecase.GetWeatherUseCase
import kotlinx.coroutines.launch

class WeatherViewModel(private val useCase: GetWeatherUseCase) : ViewModel() {

    private val _forecast = MutableLiveData<List<ForecastItem>>()
    val forecast: LiveData<List<ForecastItem>> get() = _forecast

    fun loadForecast(lat: Double, lon: Double) {
        viewModelScope.launch {
            try {
                val result = useCase(lat, lon)
                _forecast.value = result
            } catch (e: Exception) {
                Log.e("WeatherViewModel", "Ошибка загрузки", e)
            }
        }
    }
}