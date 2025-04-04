package com.ericandpau.pokeshopk.adaptercarro

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ericandpau.pokeshopk.Pokemon
import com.ericandpau.pokeshopk.R

class CarretoAdapter(private val items: List<Pokemon>) : RecyclerView.Adapter<CarretoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarretoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_carro, parent, false)
        return CarretoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarretoViewHolder, position: Int) {
        holder.render(items[position])
    }

    override fun getItemCount() = items.size
}