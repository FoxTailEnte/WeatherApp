package com.example.weatherapi.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapi.R
import com.example.weatherapi.databinding.ListItemBinding
import com.squareup.picasso.Picasso

class WeatherAdapter(val listener:Listener?): ListAdapter<WeatherModel, WeatherAdapter.WeatherHolder>(MyComparator()) {

    class WeatherHolder(view:View, val listener: Listener?): RecyclerView.ViewHolder(view){
        val binding = ListItemBinding.bind(view)
        var itemTemp: WeatherModel? = null
        init {
            itemView.setOnClickListener {
                itemTemp?.let { it1 -> listener?.onClick(it1) }
            }
        }

        fun setData(item: WeatherModel)= with(binding){
            itemTemp = item
            tvDate.text = item.time
            tvCondition.text = item.condition
            tvTemp.text = item.currentTemp.ifEmpty {"${item.maxTemp}°C / ${item.minTemp}°C"}
            Picasso.get().load("https:" + item.imageUrl).into(im)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return WeatherHolder(view,listener)
    }

    override fun onBindViewHolder(holder: WeatherHolder, position: Int) {
        holder.setData(getItem(position))
    }

    class MyComparator: DiffUtil.ItemCallback<WeatherModel>(){

        override fun areItemsTheSame(oldItem: WeatherModel, newItem: WeatherModel): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(oldItem: WeatherModel, newItem: WeatherModel): Boolean {
            return oldItem==newItem
        }

    }
    interface Listener{
        fun onClick(item: WeatherModel)
    }
}