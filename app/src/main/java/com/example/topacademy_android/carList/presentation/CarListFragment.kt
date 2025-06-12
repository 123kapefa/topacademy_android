package com.example.topacademy_android.carList.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.topacademy_android.R
import com.example.topacademy_android.carList.presentation.adapter.CarAdapter
import com.example.topacademy_android.carList.presentation.viewmodel.CarViewModel
import com.example.topacademy_android.databinding.FragmentCarListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CarListFragment : Fragment(R.layout.fragment_car_list) {

    private var _binding: FragmentCarListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CarViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCarListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbar()
        setupObservers()
        viewModel.loadCars()
    }

    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            activity?.onBackPressedDispatcher?.onBackPressed()
        }
    }

    private fun setupObservers() {
        viewModel.cars.observe(viewLifecycleOwner) { carList ->
            val adapter = CarAdapter(carList) { selectedCar ->
                val action = CarListFragmentDirections.actionCarListToCarDetail(
                    carBrand = selectedCar.brand,
                    carModel = selectedCar.model,
                    carYear = selectedCar.year,
                    carDescription = selectedCar.description,
                    carCost = selectedCar.cost,
                    carImage = selectedCar.imageResId
                )
                findNavController().navigate(action)
            }
            binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
            binding.recyclerView.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}