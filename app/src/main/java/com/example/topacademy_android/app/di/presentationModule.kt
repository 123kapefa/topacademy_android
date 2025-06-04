package com.example.topacademy_android.app.di

import com.example.topacademy_android.calculator.presentation.CalculatorViewModel
import com.example.topacademy_android.carList.presentation.viewmodel.CarViewModel
import com.example.topacademy_android.weather.presentation.WeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { CalculatorViewModel(get()) }
    viewModel { CarViewModel(get()) }
    viewModel { WeatherViewModel(get()) }
}
