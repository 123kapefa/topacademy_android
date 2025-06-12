package com.example.topacademy_android.login.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.topacademy_android.R
import com.example.topacademy_android.databinding.FragmentLoginBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class LoginFragment : Fragment(R.layout.fragment_login) {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView).visibility =
            View.GONE

        binding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_calculator)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView).visibility =
            View.VISIBLE
        super.onDestroy()
    }
}
