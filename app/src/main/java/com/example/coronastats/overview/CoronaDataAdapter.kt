package com.example.coronastats.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.coronastats.R
import com.example.coronastats.databinding.OverviewItemBinding
import com.example.coronastats.network.CountryData

class CoronaDataAdapter: ListAdapter<CountryData, CoronaDataAdapter.ViewHolder>(DiffCallback) {

    private var clickListener: OnItemClickListener? = null

    class ViewHolder(
        private val binding: OverviewItemBinding,
        clickListener: OnItemClickListener?
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.baseLayout.setOnClickListener {
                if (clickListener != null) {
                    if (adapterPosition != RecyclerView.NO_POSITION) {
                        clickListener.onItemClick(adapterPosition)
                    }
                }
            }
        }

        fun bind(countryData: CountryData) {
            binding.country = countryData
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<CountryData>() {
        override fun areItemsTheSame(oldItem: CountryData, newItem: CountryData): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: CountryData, newItem: CountryData): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(OverviewItemBinding.inflate(inflater, parent, false), clickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val countryData = getItem(position)
        if (position % 2 == 0) {
            holder.itemView.setBackgroundColor(
            ContextCompat.getColor(holder.itemView.context, R.color.design_default_color_secondary_variant)
            )
        } else {
            holder.itemView.setBackgroundColor(
                ContextCompat.getColor(holder.itemView.context, R.color.design_default_color_secondary)
            )
        }
        holder.bind(countryData)
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.clickListener = listener
    }
}