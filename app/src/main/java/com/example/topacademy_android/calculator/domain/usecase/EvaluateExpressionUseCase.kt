package com.example.topacademy_android.calculator.domain.usecase

import com.example.topacademy_android.calculator.domain.repository.CalculatorRepository

class EvaluateExpressionUseCase(private val repository: CalculatorRepository) {
    fun execute(expression: String): Double {
        return repository.evaluate(expression)
    }
}