package com.example.topacademy_android.calculator.presentation.state

data class CalculatorUiState(
    val expression: String = "",
    val result: String = "",
    val isCalculated: Boolean = false
)
