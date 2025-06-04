package com.example.topacademy_android.app.di

import org.koin.dsl.module
import com.example.topacademy_android.calculator.domain.usecase.EvaluateExpressionUseCase
import com.example.topacademy_android.carList.domain.usecase.GetCarsUseCase
import com.example.topacademy_android.weather.domain.usecase.GetWeatherUseCase

val domainModule = module {

    factory { EvaluateExpressionUseCase(get()) }
    factory { GetCarsUseCase(get()) }
    factory { GetWeatherUseCase(get()) }

}
