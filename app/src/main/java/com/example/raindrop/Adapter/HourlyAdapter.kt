package com.example.raindrop.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.raindrop.Model.HourlyModel
import com.example.raindrop.databinding.ViewholderHourlyBinding
import com.google.android.material.color.utilities.Contrast


class HourlyAdapter(private val items:ArrayList<HourlyModel>)
    :RecyclerView.Adapter<HourlyAdapter.Viewholder>() {

        private lateinit var context: Context

    class Viewholder (val binding: ViewholderHourlyBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Viewholder {
        context=parent.context
        val binding=ViewholderHourlyBinding
            .inflate(LayoutInflater.from(context),parent,false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder:HourlyAdapter.Viewholder,position: Int) {
      val item=items[position]
        holder.binding.apply {
            hourTxt.text=item.hour
            tempTxt.text="${item.temp}"

            val drawableResourceId = holder.itemView.resources.getIdentifier(
                item.picPath,
                "drawable",
                context.packageName
            )
            Glide.with(context)
                .load(drawableResourceId)
                .into(pic)
        }
    }

    override fun getItemCount(): Int = items.size ;




}