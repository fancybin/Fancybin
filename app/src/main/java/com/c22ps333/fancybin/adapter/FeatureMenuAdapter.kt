package com.c22ps333.fancybin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.c22ps333.fancybin.databinding.MenuFeatureItemBinding
import com.c22ps333.fancybin.model.FeatureMenu

class FeatureMenuAdapter(private val listFeature: ArrayList<FeatureMenu>) : RecyclerView.Adapter<FeatureMenuAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = MenuFeatureItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listFeature[position])

        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Kamu memilih " + listFeature[holder.adapterPosition].title, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {

        val limit = 3

        if (listFeature.size > limit) {
            return limit
        } else {
            return listFeature.size
        }
    }

    class ViewHolder(private val binding: MenuFeatureItemBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(featureMenu: FeatureMenu) {
            binding.apply {
                tvTitleFeature.text = featureMenu.title
                tvDescFeature.text = featureMenu.description
                ivImageFeature.setImageResource(featureMenu.image)
            }
        }
    }
}