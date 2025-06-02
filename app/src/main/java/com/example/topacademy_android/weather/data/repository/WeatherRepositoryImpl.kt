package com.example.topacademy_android.weather.data.repository

import com.example.topacademy_android.weather.data.remote.api.WeatherApi
import com.example.topacademy_android.weather.data.mapper.toDomain
import com.example.topacademy_android.weather.domain.model.ForecastItem
import com.example.topacademy_android.weather.domain.repository.WeatherRepository

class WeatherRepositoryImpl(private val api: WeatherApi) : WeatherRepository {
    override suspend fun getForecast(lat: Double, lon: Double): List<ForecastItem> {
        val apiKey = "eaf543a809e83fb5339069b5184ba3d1"
        val dtoList = api.getForecast(lat, lon, apiKey).list
        return dtoList.map { it.toDomain() }
    }
}
