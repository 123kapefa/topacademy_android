package com.example.topacademy_android.calculator.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.topacademy_android.calculator.data.repository.CalculatorRepositoryImpl
import com.example.topacademy_android.calculator.domain.usecase.EvaluateExpressionUseCase
import com.example.topacademy_android.calculator.presentation.state.CalculatorUiState

class CalculatorViewModel : ViewModel() {

    private val repository = CalculatorRepositoryImpl()
    private val useCase = EvaluateExpressionUseCase(repository)

    private val _uiState = MutableLiveData(CalculatorUiState())
    val uiState: LiveData<CalculatorUiState> = _uiState

    fun appendSymbol(symbol: String) {
        val current = _uiState.value ?: CalculatorUiState()

        if (current.isCalculated) {
            _uiState.value = CalculatorUiState(expression = symbol, result = "", isCalculated = false)
        } else {
            _uiState.value = current.copy(
                expression = current.expression + symbol,
                result = "",
                isCalculated = false
            )
        }
    }

    fun clear() {
        _uiState.value = CalculatorUiState()
    }

    fun deleteLast() {
        val current = _uiState.value ?: CalculatorUiState()
        val newExpr = current.expression.dropLast(1)
        _uiState.value = current.copy(expression = newExpr)
    }

    fun evaluate() {
        val expr = _uiState.value?.expression ?: ""
        try {
            val result = useCase.execute(expr)
            _uiState.value = CalculatorUiState(
                expression = expr,
                result = result.toString(),
                isCalculated = true
            )
        } catch (e: Exception) {
            _uiState.value = CalculatorUiState(
                expression = expr,
                result = "Ошибка",
                isCalculated = true
            )
        }
    }
}
