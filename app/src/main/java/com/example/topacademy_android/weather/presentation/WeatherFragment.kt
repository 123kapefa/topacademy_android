package com.example.topacademy_android.weather.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.topacademy_android.databinding.FragmentWeatherBinding
import com.example.topacademy_android.weather.presentation.adapter.WeatherAdapter

class WeatherFragment : Fragment() {

    private val viewModel: WeatherViewModel by viewModel()

    private var _binding: FragmentWeatherBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = WeatherAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel.forecast.observe(viewLifecycleOwner) { forecast ->
            adapter.submitList(forecast)
        }

        viewModel.loadForecast(55.7558, 37.6173)

        setupToolbar()
    }

    private fun setupToolbar() {
        binding.toolbar.title = "Weather"
        binding.toolbar.setNavigationIcon(com.example.topacademy_android.R.drawable.arrow_left)
        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
