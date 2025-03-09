package com.ericandpau.pokeshopk

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.ericandpau.pokeshopk.Pokemon
import com.ericandpau.pokeshopk.R

class PokemonAdapter(
    private var pokemonList: MutableList<Pokemon>,
    private val onDelete: (Int) -> Unit
) : RecyclerView.Adapter<PokemonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PokemonViewHolder(layoutInflater.inflate(R.layout.item_pokemon, parent, false))
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val item = pokemonList[position]

        holder.render(item)

        val addToCartButton: Button = holder.itemView.findViewById(R.id.compraButton)
        addToCartButton.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Afegit al carreto", Toast.LENGTH_SHORT).show()
        }

        val deleteButton: ImageButton = holder.itemView.findViewById(R.id.btnEliminar)
        deleteButton.setOnClickListener {
            onDelete(item.id)
        }
    }

    fun updateList(newList: List<Pokemon>) {
        pokemonList.clear()
        pokemonList.addAll(newList)
        notifyDataSetChanged()
    }
}
