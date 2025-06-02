package com.example.topacademy_android.carList.domain.repository

import com.example.topacademy_android.carList.domain.model.Car

interface CarRepository {
    fun getCars(): List<Car>
}