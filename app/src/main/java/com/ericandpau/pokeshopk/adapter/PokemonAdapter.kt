package com.ericandpau.pokeshopk

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ericandpau.pokeshopk.Pokemon
import com.ericandpau.pokeshopk.R

class PokemonAdapter(val pokemonList:List<Pokemon>) : RecyclerView.Adapter<PokemonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context);
        return PokemonViewHolder(layoutInflater.inflate(R.layout.item_pokemon, parent, false));
    }

    override fun getItemCount(): Int {
        return pokemonList.size;
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val item = pokemonList[position]
        holder.render(item)
    }


}