package com.example.topacademy_android.carList.data.model

data class CarEntity(
    val brand: String,
    val model: String,
    val year: Int,
    val description: String,
    val cost: Int,
    val imageResId: Int
)