package com.ericandpau.pokeshopk

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ericandpau.pokeshopk.adaptercarro.Carreto
import com.ericandpau.pokeshopk.adaptercarro.CarretoAdapter
import com.google.gson.Gson

class CarretoActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CarretoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carreto)
        val comandaButton: Button = findViewById(R.id.comanda)
        val btnStats: Button = findViewById(R.id.estadistica)
        comandaButton.setOnClickListener {
            val intent = Intent(this@CarretoActivity, ComandaRealitzadaActivity::class.java)
            startActivity(intent)
        }
        btnStats.setOnClickListener {
            val gson = Gson()
            // Extraiem dades dels pokemons guardats al carro
            val dadesPokemons = Carreto.items.map { pokemon ->
                mapOf(
                    "id" to pokemon.id,
                    "nom" to pokemon.nom,
                    "tipo" to pokemon.tipo,
                    "altura" to pokemon.altura
                )
            }
            // Ho passem a format json
            val jsonString = gson.toJson(dadesPokemons)

            // Guardem l'arxiu
            try {
                val fileName = "comanda.json"
                openFileOutput(fileName, MODE_PRIVATE).use { output ->
                    output.write(jsonString.toByteArray())
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(this, "Error al guardar la comanda", Toast.LENGTH_SHORT).show()
            }
        }
        recyclerView = findViewById(R.id.recycler_carreto)
        recyclerView.layoutManager = LinearLayoutManager(this)

        actualitzarCarrito()
    }

    override fun onResume() {
        super.onResume()
        actualitzarCarrito()
    }

    private fun actualitzarCarrito() {
        adapter = CarretoAdapter(Carreto.items.toMutableList()) { pokemonAEliminar ->
            Carreto.items.remove(pokemonAEliminar)
            Toast.makeText(this, "Esborrat del carreto", Toast.LENGTH_SHORT).show()
            adapter.notifyDataSetChanged()
            actualitzarCarrito()
        }
        recyclerView.adapter = adapter
    }
}