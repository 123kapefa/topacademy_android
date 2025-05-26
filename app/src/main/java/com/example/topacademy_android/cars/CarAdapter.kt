package com.example.topacademy_android.cars

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.topacademy_android.databinding.ItemCarBinding
import android.view.LayoutInflater

class CarAdapter(
    private val items: List<Car>,
    private val onDetailsClick: (Car) -> Unit
) : RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    class CarViewHolder(val binding: ItemCarBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val binding = ItemCarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val item = items[position]
        with(holder.binding) {
            tvBrand.text = item.brand
            tvModel.text = item.model
            ivCar.setImageResource(item.imageResId)
            btnDetails.setOnClickListener {
                onDetailsClick(item)
            }
        }
    }

    override fun getItemCount(): Int = items.size
}
