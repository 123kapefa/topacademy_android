package com.example.topacademy_android.carList.domain.usecase

import com.example.topacademy_android.carList.data.repository.CarRepositoryImpl
import com.example.topacademy_android.carList.domain.model.Car

class GetCarsUseCase(private val repository: CarRepositoryImpl) {
    fun execute(): List<Car> = repository.getCars()
}