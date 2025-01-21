package com.ericandpau.pokeshopk
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ericandpau.pokeshopk.Pokemon
import com.ericandpau.pokeshopk.R

class PokemonViewHolder(view:View):RecyclerView.ViewHolder(view) {

    val pokemon = view.findViewById<TextView>(R.id.textPokemon)
    val photo = view.findViewById<ImageView>(R.id.foto)

    fun render(pokemonModel: Pokemon){

        pokemon.text = pokemonModel.text
        Glide.with(photo.context).load(pokemonModel.photo).into(photo)
    }


}