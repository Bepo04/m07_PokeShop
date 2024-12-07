package com.ericandpau.pokeshopk

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat

class CarretoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(R.layout.activity_carreto)

        val comandaButton: Button = findViewById(R.id.comanda)

        comandaButton.setOnClickListener {
                val intent = Intent(this@CarretoActivity, ComandaRealitzadaActivity::class.java)
            startActivity(intent)
        }
    }
}