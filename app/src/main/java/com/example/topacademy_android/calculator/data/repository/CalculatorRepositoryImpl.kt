package com.example.topacademy_android.calculator.data.repository

import com.example.topacademy_android.calculator.domain.repository.CalculatorRepository
import net.objecthunter.exp4j.ExpressionBuilder

class CalculatorRepositoryImpl : CalculatorRepository {

    override fun evaluate(expression: String): Double {
        val result = ExpressionBuilder(expression).build().evaluate()
        return if (result.isFinite()) result else throw ArithmeticException("Invalid result")
    }
}
