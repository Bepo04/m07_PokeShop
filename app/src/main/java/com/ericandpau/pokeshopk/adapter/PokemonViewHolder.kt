package com.ericandpau.pokeshopk
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ericandpau.pokeshopk.Pokemon
import com.ericandpau.pokeshopk.R

class PokemonViewHolder(view:View):RecyclerView.ViewHolder(view) {

    val textNom = view.findViewById<TextView>(R.id.textNom)
    val textTipo = view.findViewById<TextView>(R.id.textTipo)
    val textAlsada = view.findViewById<TextView>(R.id.textAlsada)
    val foto = view.findViewById<ImageView>(R.id.foto)

    fun render(pokemonModel: Pokemon){

        textNom.text = pokemonModel.nom
        textTipo.text = "Tipus: ${pokemonModel.tipo}"
        textAlsada.text = "Alçada: ${pokemonModel.altura}"

        Glide.with(foto.context)
            .load(pokemonModel.imgUrl)
            .into(foto)
    }
}