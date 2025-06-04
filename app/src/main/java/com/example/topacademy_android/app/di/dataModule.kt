package com.example.topacademy_android.app.di

import com.example.topacademy_android.calculator.data.repository.CalculatorRepositoryImpl
import com.example.topacademy_android.calculator.domain.repository.CalculatorRepository
import com.example.topacademy_android.carList.data.repository.CarRepositoryImpl
import com.example.topacademy_android.carList.domain.repository.CarRepository
import com.example.topacademy_android.weather.data.repository.WeatherRepositoryImpl
import com.example.topacademy_android.weather.domain.repository.WeatherRepository
import org.koin.dsl.module

val dataModule = module {

    single<CalculatorRepository> { CalculatorRepositoryImpl() }
    single<CarRepository> { CarRepositoryImpl() }
    single<WeatherRepository> { WeatherRepositoryImpl(get()) }

}