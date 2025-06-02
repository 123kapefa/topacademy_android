package com.example.topacademy_android.weather.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.topacademy_android.R
import com.example.topacademy_android.databinding.ItemWeatherCardBinding
import com.example.topacademy_android.weather.domain.model.ForecastItem

class WeatherAdapter : ListAdapter<ForecastItem, WeatherAdapter.ViewHolder>(DiffCallback()) {

    inner class ViewHolder(val binding: ItemWeatherCardBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemWeatherCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.tvTemp.text = "${item.temperature}°C"
        holder.binding.tvDesc.text = item.condition
        holder.binding.tvDate.text = item.date

        val context = holder.itemView.context

        when {
            item.condition.contains("rain", true) -> {
                holder.binding.ivIcon.setImageResource(R.drawable.ic_rain)
                holder.binding.root.setCardBackgroundColor(
                    ContextCompat.getColor(context, R.color.rainBackground)
                )
            }

            item.condition.contains("cloud", true) -> {
                holder.binding.ivIcon.setImageResource(R.drawable.ic_cloud)
                holder.binding.root.setCardBackgroundColor(
                    ContextCompat.getColor(context, R.color.cloudyBackground)
                )
            }

            item.condition.contains("sun", true)
                    || item.condition.contains("clear", true) -> {
                holder.binding.ivIcon.setImageResource(R.drawable.ic_sun)
                holder.binding.root.setCardBackgroundColor(
                    ContextCompat.getColor(context, R.color.sunnyBackground)
                )
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<ForecastItem>() {
        override fun areItemsTheSame(oldItem: ForecastItem, newItem: ForecastItem) =
            oldItem.date == newItem.date

        override fun areContentsTheSame(oldItem: ForecastItem, newItem: ForecastItem) =
            oldItem == newItem
    }
}
