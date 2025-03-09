package com.ericandpau.pokeshopk

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.Insets
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ericandpau.pokeshopk.PokemonAdapter
import com.ericandpau.pokeshopk.data.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContentView(R.layout.activity_products)

        val mainView: View = findViewById(R.id.main)
        ViewCompat.setOnApplyWindowInsetsListener(mainView) { v, insets ->
            val systemBars: Insets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnFiltres: ImageButton = findViewById(R.id.btnFiltres)
        btnFiltres.setOnClickListener {
            val intent = Intent(this, Filters::class.java)
            startActivity(intent)
        }

        initRecyclerView()
        loadPokemons()
    }

    fun initRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.rv)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun loadPokemons() {
        lifecycleScope.launch {
            try {
                // Trucada asincrona a la API
                val pokemons = withContext(Dispatchers.IO) {
                    RetrofitInstance.api.getPokemons()
                }
                Log.d("ProductsActivity", "Pokemons obtenidos: $pokemons")
                // Actualitzem la vista
                updateRecyclerView(pokemons)
            } catch (e: Exception) {
                e.printStackTrace()
                Log.e("ProductsActivity", "Error al cargar Pokémons: ${e.message}")
            }
        }
    }

    private fun deletePokemon(id: Int) {
        lifecycleScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    RetrofitInstance.api.deletePokemon(id)
                }
                if (response.isSuccessful) {
                    Toast.makeText(this@ProductsActivity, "Eliminat correctament", Toast.LENGTH_SHORT).show()
                    loadPokemons()
                } else {
                    Toast.makeText(this@ProductsActivity, "Error eliminant Pokémon", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Log.e("ProductsActivity", "Error al eliminar Pokémon: ${e.message}")
                Toast.makeText(this@ProductsActivity, "Error de xarxa", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun updateRecyclerView(pokemons: List<Pokemon>) {
        val recyclerView = findViewById<RecyclerView>(R.id.rv)
        recyclerView.adapter = PokemonAdapter(pokemons.toMutableList()) { pokemonId ->
            deletePokemon(pokemonId)
        }
    }
}