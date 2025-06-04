package com.example.topacademy_android.calculator.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.topacademy_android.databinding.FragmentCalculatorBinding

class CalculatorFragment : Fragment() {

    private var _binding: FragmentCalculatorBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: CalculatorViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[CalculatorViewModel::class.java]

        viewModel.uiState.observe(viewLifecycleOwner) { state ->
            if (state.isCalculated) {
                binding.tvExpression.text = state.expression
                binding.tvResult.text = state.result
            } else {
                binding.tvExpression.text = ""
                binding.tvResult.text = state.expression
            }
        }

        setListeners()
    }

    private fun setListeners() = with(binding) {
        btnZero.setOnClickListener { viewModel.appendSymbol("0") }
        btnOne.setOnClickListener { viewModel.appendSymbol("1") }
        btnTwo.setOnClickListener { viewModel.appendSymbol("2") }
        btnThree.setOnClickListener { viewModel.appendSymbol("3") }
        btnFour.setOnClickListener { viewModel.appendSymbol("4") }
        btnFive.setOnClickListener { viewModel.appendSymbol("5") }
        btnSix.setOnClickListener { viewModel.appendSymbol("6") }
        btnSeven.setOnClickListener { viewModel.appendSymbol("7") }
        btnEight.setOnClickListener { viewModel.appendSymbol("8") }
        btnNine.setOnClickListener { viewModel.appendSymbol("9") }

        btnDot.setOnClickListener { viewModel.appendSymbol(".") }
        btnPlus.setOnClickListener { viewModel.appendSymbol("+") }
        btnMinus.setOnClickListener { viewModel.appendSymbol("-") }
        btnMultiply.setOnClickListener { viewModel.appendSymbol("*") }
        btnDivide.setOnClickListener { viewModel.appendSymbol("/") }
        btnPercent.setOnClickListener { viewModel.appendSymbol("%") }

        btnClear.setOnClickListener { viewModel.clear() }
        btnBackspace.setOnClickListener { viewModel.deleteLast() }
        btnEqual.setOnClickListener { viewModel.evaluate() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}