package com.ericandpau.pokeshopk

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.Insets
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ericandpau.pokeshopk.PokemonProvider
import com.ericandpau.pokeshopk.PokemonAdapter

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

    }

    fun initRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.rv)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PokemonAdapter(PokemonProvider.pokemons)




    }

}