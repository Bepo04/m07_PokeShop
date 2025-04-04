package com.ericandpau.pokeshopk.adaptercarro

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ericandpau.pokeshopk.Pokemon
import com.ericandpau.pokeshopk.R

class CarretoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val textNom: TextView = view.findViewById(R.id.nom_pokemon)
    val textTipo: TextView = view.findViewById(R.id.tipo_pokemon)
    val textAltura: TextView = view.findViewById(R.id.altura_pokemon)
    val textPrecio: TextView = view.findViewById(R.id.preu)
    val foto: ImageView = view.findViewById(R.id.foto)

    fun render(pokemon: Pokemon) {
        textNom.text = "${pokemon.nom.uppercase()}"
        textTipo.text = "Tipus: ${pokemon.tipo.uppercase()}"
        textAltura.text = "Alçada: ${pokemon.altura} cm"
        textPrecio.text = "Preu: ${'$'}${pokemon.altura * 100}" // Precio ficticio basado en altura
        Glide.with(foto.context)
            .load(pokemon.imgUrl)
            .into(foto)
    }
}