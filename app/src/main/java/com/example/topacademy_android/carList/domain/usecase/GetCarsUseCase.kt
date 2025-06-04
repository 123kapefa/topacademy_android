package com.example.topacademy_android.carList.domain.usecase

import com.example.topacademy_android.carList.domain.model.Car
import com.example.topacademy_android.carList.domain.repository.CarRepository

class GetCarsUseCase(private val repository: CarRepository) {
    fun execute(): List<Car> = repository.getCars()
}