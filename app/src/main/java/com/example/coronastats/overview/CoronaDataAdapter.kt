package com.example.coronastats.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.coronastats.R
import com.example.coronastats.databinding.OverviewItemBinding
import com.example.coronastats.network.CountryData

class CoronaDataAdapter: androidx.recyclerview.widget.ListAdapter<CountryData, CoronaDataAdapter.ViewHolder>(DiffCallback) {


    class ViewHolder(private val binding: OverviewItemBinding):  RecyclerView.ViewHolder(binding.root) {
        fun bind(countryData: CountryData) {
            binding.country = countryData
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback: DiffUtil.ItemCallback<CountryData>() {
        override fun areItemsTheSame(oldItem: CountryData, newItem: CountryData): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: CountryData, newItem: CountryData): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(OverviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val countryData = getItem(position)
        if (position % 2 == 0) {
            holder.itemView.setBackgroundColor(ResourcesCompat.getColor(holder.itemView.resources, R.color.blue_50, null))
        }
        else {
            holder.itemView.setBackgroundColor(ResourcesCompat.getColor(holder.itemView.resources, R.color.white, null))
        }
        holder.bind(countryData)
    }
}