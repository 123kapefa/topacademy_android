package com.example.topacademy_android.carList.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.topacademy_android.carList.domain.model.Car
import com.example.topacademy_android.carList.domain.usecase.GetCarsUseCase

class CarViewModel(private val useCase: GetCarsUseCase) : ViewModel() {

    private val _cars = MutableLiveData<List<Car>>()
    val cars: LiveData<List<Car>> get() = _cars

    fun loadCars() {
        _cars.value = useCase.execute()
    }
}