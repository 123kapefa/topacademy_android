package com.example.topacademy_android.weather.domain.repository

import com.example.topacademy_android.weather.domain.model.ForecastItem

interface WeatherRepository {
    suspend fun getForecast(lat: Double, lon: Double): List<ForecastItem>
}