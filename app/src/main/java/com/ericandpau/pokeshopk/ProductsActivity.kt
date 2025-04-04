package com.ericandpau.pokeshopk

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.Insets
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ericandpau.pokeshopk.data.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContentView(R.layout.activity_products)

        val btnFiltres: ImageButton = findViewById(R.id.btnFiltres)
        btnFiltres.setOnClickListener {
            val intent = Intent(this, Filters::class.java)
            startActivity(intent)
        }

        val btnAddPokemon: Button = findViewById(R.id.btnAfegir)
        btnAddPokemon.setOnClickListener {
            showAddPokemonDialog()
        }

        val editTextSearch: EditText = findViewById(R.id.searchText)
        val btnSearch: ImageButton = findViewById(R.id.searchIcon)
        btnSearch.setOnClickListener {
            val searchText = editTextSearch.text.toString().trim()
            if (searchText.isNotEmpty()) {
                searchPokemons(searchText)
            } else {
                Toast.makeText(this@ProductsActivity, "No s'ha trobat cap resultat", Toast.LENGTH_SHORT).show()
                loadPokemons()
            }
        }

        initRecyclerView()
        loadPokemons()
    }

    fun initRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.rv)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    fun updateRecyclerView(pokemons: List<Pokemon>) {
        val recyclerView = findViewById<RecyclerView>(R.id.rv)
        recyclerView.adapter = PokemonAdapter(pokemons.toMutableList()) { pokemonId ->
            deletePokemon(pokemonId)
        }
    }

     fun loadPokemons() {
        lifecycleScope.launch {
            try {
                // Trucada asincrona a la API
                val pokemons = withContext(Dispatchers.IO) {
                    RetrofitInstance.api.getPokemons()
                }
                Log.d("ProductsActivity", "Pokemons obtenidos: $pokemons")
                updateRecyclerView(pokemons)
            } catch (e: Exception) {
                e.printStackTrace()
                Log.e("ProductsActivity", "Error al cargar Pokémons: ${e.message}")
            }
        }
    }

    fun deletePokemon(id: Int) {
        lifecycleScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    RetrofitInstance.api.deletePokemon(id)
                }
                if (response.isSuccessful) {
                    Toast.makeText(this@ProductsActivity, "Eliminat correctament", Toast.LENGTH_SHORT).show()
                    loadPokemons() // Recarregar la llista
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

    private fun showAddPokemonDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Añadir Pokémon")

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.setPadding(50, 20, 50, 10)

        val inputNombre = EditText(this)
        inputNombre.hint = "Nombre del Pokémon"
        layout.addView(inputNombre)

        val inputTipo = EditText(this)
        inputTipo.hint = "Tipo del Pokémon"
        layout.addView(inputTipo)

        val inputAltura = EditText(this)
        inputAltura.hint = "Altura del Pokémon"
        inputAltura.inputType = InputType.TYPE_CLASS_NUMBER
        layout.addView(inputAltura)

        builder.setView(layout)

        builder.setPositiveButton("Añadir") { _, _ ->
            val nombre = inputNombre.text.toString().trim()
            val tipo = inputTipo.text.toString().trim()
            val altura = inputAltura.text.toString().trim().toIntOrNull() ?: 0

            if (nombre.isNotEmpty() && tipo.isNotEmpty() && altura > 0) {
                addPokemonToApi(nombre, tipo, altura)
            } else {
                Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
            }
        }

        builder.setNegativeButton("Cancelar") { dialog, _ -> dialog.dismiss() }

        builder.show()
    }

    private fun addPokemonToApi(nom: String, tipo: String, altura: Int) {
        lifecycleScope.launch {
            try {
                val newPokemon = Pokemon(
                    id = 0,
                    nom = nom,
                    tipo = tipo,
                    altura = altura,
                    imgUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/10095.png"
                )
                val response = withContext(Dispatchers.IO) {
                    RetrofitInstance.api.addPokemon(
                        nom,
                        tipo,
                        altura,
                        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/10095.png"
                    )
                }

                if (response.isSuccessful) {
                    Toast.makeText(
                        this@ProductsActivity,
                        "Pokémon afegit correctament",
                        Toast.LENGTH_SHORT
                    ).show()
                    loadPokemons()
                } else {
                    Log.e("RESPONSE:", response.toString())
                    Toast.makeText(
                        this@ProductsActivity,
                        "Error al afegir Pokémon",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(this@ProductsActivity, "Error de conexió", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun searchPokemons(text: String) {
        lifecycleScope.launch {
            try {
                Log.d("API_REQUEST", "Buscando: $text")
                val pokemons = withContext(Dispatchers.IO) {
                    RetrofitInstance.api.searchPokemons(text)
                }
                updateRecyclerView(pokemons)
            } catch (e: Exception) {
                Log.e("ProductsActivity", "Error al buscar Pokémon: ${e.message}", e)
                Toast.makeText(this@ProductsActivity, "Error al buscar Pokémon", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

