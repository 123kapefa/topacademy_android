package com.example.topacademy_android.calculator.domain.repository

interface CalculatorRepository {
    fun evaluate(expression: String): Double
}