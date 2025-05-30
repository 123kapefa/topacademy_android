package com.example.topacademy_android.weather.data.mapper

import com.example.topacademy_android.weather.data.remote.dto.ForecastDto
import com.example.topacademy_android.weather.domain.model.ForecastItem

fun ForecastDto.toDomain(): ForecastItem {
    return ForecastItem(
        date = dt_txt,
        temperature = main.temp,
        condition = weather.firstOrNull()?.description ?: "unknown"
    )
}