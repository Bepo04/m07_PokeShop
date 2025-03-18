package com.ericandpau.pokeshopk

import android.app.AlertDialog
import android.content.Context
import android.text.InputType
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.ericandpau.pokeshopk.Pokemon
import com.ericandpau.pokeshopk.R
import com.ericandpau.pokeshopk.data.PokemonUpdateRequest
import com.ericandpau.pokeshopk.data.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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

        val comprarButton: Button = holder.itemView.findViewById(R.id.btnComprar)
        comprarButton.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Afegit al carreto", Toast.LENGTH_SHORT).show()
        }

        val modificarButton: ImageButton = holder.itemView.findViewById(R.id.btnModificar)
        modificarButton.setOnClickListener {
            showEditPokemonDialog(holder.itemView.context, item)
        }

        val deleteButton: ImageButton = holder.itemView.findViewById(R.id.btnEliminar)
        deleteButton.setOnClickListener {
            onDelete(item.id)
        }
    }



    private fun showEditPokemonDialog(context: Context, pokemon: Pokemon) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Modificar Pokémon")

        val layout = LinearLayout(context)
        layout.orientation = LinearLayout.VERTICAL
        layout.setPadding(50, 20, 50, 10)

        val inputId = EditText(context)
        inputId.hint = "ID del Pokémon"
        inputId.setText(pokemon.id.toString())
        inputId.isEnabled = false
        layout.addView(inputId)

        val inputNom = EditText(context)
        inputNom.hint = "Nom"
        inputNom.setText(pokemon.nom)
        layout.addView(inputNom)

        val inputTipo = EditText(context)
        inputTipo.hint = "Tipus"
        inputTipo.setText(pokemon.tipo)
        layout.addView(inputTipo)

        val inputAltura = EditText(context)
        inputAltura.hint = "Alçada"
        inputAltura.setText(pokemon.altura.toString())
        inputAltura.inputType = InputType.TYPE_CLASS_NUMBER
        layout.addView(inputAltura)

        builder.setView(layout)

        builder.setPositiveButton("Modificar") { _, _ ->
            val nom = inputNom.text.toString().trim()
            val tipo = inputTipo.text.toString().trim()
            val altura = inputAltura.text.toString().trim().toIntOrNull() ?: 0

            if (nom.isNotEmpty() && tipo.isNotEmpty() && altura > 0) {
                updatePokemonInApi(context, pokemon.id, nom, tipo, altura)
            } else {
                Toast.makeText(context, "Tots els camps són obligatoris", Toast.LENGTH_SHORT).show()
            }
        }

        builder.setNegativeButton("Cancelar") { dialog, _ -> dialog.dismiss() }

        builder.show()
    }

    private fun updatePokemonInApi(context: Context, id: Int, nom: String, tipo: String, altura: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                Log.d("API_CALL", "Enviant PATCH per a ID=$id | nom=$nom | tipo=$tipo | altura=$altura")

                val response = RetrofitInstance.api.updatePokemon(id, nom, tipo, altura)

                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        Toast.makeText(context, "Pokémon modificat correctament", Toast.LENGTH_SHORT).show()
                        (context as? ProductsActivity)?.loadPokemons()
                    } else {
                        val errorBody = response.errorBody()?.string()
                        Log.e("API_ERROR", "Error al modificar Pokémon: $errorBody")
                        Toast.makeText(context, "Error al modificar Pokémon", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Error de connexió", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }






    fun updateList(newList: List<Pokemon>) {
        pokemonList.clear()
        pokemonList.addAll(newList)
        notifyDataSetChanged()
    }
}
