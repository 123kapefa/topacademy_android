package com.example.topacademy_android.calculator.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
//import com.example.topacademy_android.databinding.ActivityCalculatorBinding

//class CalculatorActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityCalculatorBinding
//    private val viewModel = CalculatorViewModel()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityCalculatorBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        viewModel.uiState.observe(this) { state ->
//            if (state.isCalculated) {
//                binding.tvExpression.text = state.expression
//                binding.tvResult.text = state.result
//            } else {
//                binding.tvExpression.text = ""
//                binding.tvResult.text = state.expression
//            }
//        }
//
//        setListeners()
//    }
//
//    private fun setListeners() {
//        binding.btnZero.setOnClickListener { viewModel.appendSymbol("0") }
//        binding.btnOne.setOnClickListener { viewModel.appendSymbol("1") }
//        binding.btnTwo.setOnClickListener { viewModel.appendSymbol("2") }
//        binding.btnThree.setOnClickListener { viewModel.appendSymbol("3") }
//        binding.btnFour.setOnClickListener { viewModel.appendSymbol("4") }
//        binding.btnFive.setOnClickListener { viewModel.appendSymbol("5") }
//        binding.btnSix.setOnClickListener { viewModel.appendSymbol("6") }
//        binding.btnSeven.setOnClickListener { viewModel.appendSymbol("7") }
//        binding.btnEight.setOnClickListener { viewModel.appendSymbol("8") }
//        binding.btnNine.setOnClickListener { viewModel.appendSymbol("9") }
//
//        binding.btnDot.setOnClickListener { viewModel.appendSymbol(".") }
//        binding.btnPlus.setOnClickListener { viewModel.appendSymbol("+") }
//        binding.btnMinus.setOnClickListener { viewModel.appendSymbol("-") }
//        binding.btnMultiply.setOnClickListener { viewModel.appendSymbol("*") }
//        binding.btnDivide.setOnClickListener { viewModel.appendSymbol("/") }
//        binding.btnPercent.setOnClickListener { viewModel.appendSymbol("%") }
//
//        binding.btnClear.setOnClickListener { viewModel.clear() }
//        binding.btnBackspace.setOnClickListener { viewModel.deleteLast() }
//        binding.btnEqual.setOnClickListener { viewModel.evaluate() }
//    }
//}
