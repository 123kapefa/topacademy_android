package com.example.topacademy_android.carList.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.topacademy_android.databinding.FragmentCarDetailBinding

class CarDetailFragment : Fragment() {

    private var _binding: FragmentCarDetailBinding? = null
    private val binding get() = _binding!!

    private val args: CarDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCarDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val brand = args.carBrand
        val model = args.carModel
        val year = args.carYear
        val description = args.carDescription
        val cost = args.carCost
        val imageResId = args.carImage

        binding.tvTitle.text = "$brand $model"
        binding.tvYear.text = "Год выпуска: $year"
        binding.tvDescription.text = description
        binding.tvCost.text = "Цена: $cost ₽"
        binding.ivCarDetail.setImageResource(imageResId)

        setupToolbar("$brand $model")
    }

    private fun setupToolbar(title: String) {
        binding.toolbar.title = title
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
