package com.ericandpau.pokeshopk

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat

class Menu : AppCompatActivity() {

    private lateinit var inici: ImageButton
    private lateinit var cart: ImageButton
    private lateinit var pokemon: ImageButton
    private lateinit var login: ImageButton
    private lateinit var registre: ImageButton
    private lateinit var settings: ImageButton
    private lateinit var help: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContentView(R.layout.activity_menu)

        inici = findViewById(R.id.inici)
        cart = findViewById(R.id.cart)
        pokemon = findViewById(R.id.pokeball)
        login = findViewById(R.id.login)
        registre = findViewById(R.id.register)
        settings = findViewById(R.id.settings)
        help = findViewById(R.id.help)

        inici.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        cart.setOnClickListener {
            startActivity(Intent(this, CarretoActivity::class.java))
        }

        pokemon.setOnClickListener {
            startActivity(Intent(this, ProductsActivity::class.java))
        }

        login.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
        }

        registre.setOnClickListener {
            startActivity(Intent(this, Register::class.java))
        }

        settings.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java)) // Cambia si `settings` tiene una actividad específica.
        }

        help.setOnClickListener {
            startActivity(Intent(this, HelpActivity::class.java))
        }
    }
}