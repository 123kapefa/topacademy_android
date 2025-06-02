package com.example.topacademy_android.carList.data.repository

import com.example.topacademy_android.R
import com.example.topacademy_android.carList.domain.model.Car
import com.example.topacademy_android.carList.domain.repository.CarRepository

class CarRepositoryImpl : CarRepository {

    override fun getCars(): List<Car> {
        return listOf(
            Car("Toyota", "Supra", 1995, "Хорошее состояние.", 5500000, R.drawable.toyota_supra),
            Car("Honda", "NSX", 1994, "Оригинальный обвес Fortune.", 4500000, R.drawable.honda_nsx),
            Car("Nissan", "Skyline", 1993, "Skyline R32.", 2700000, R.drawable.nissan_skyline)
        )
    }
}