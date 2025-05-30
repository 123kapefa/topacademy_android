package com.example.topacademy_android.weather.data.remote.dto

data class ForecastDto(
    val dt_txt: String,
    val main: MainDto,
    val weather: List<ConditionDto>
)