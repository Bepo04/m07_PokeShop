package com.ericandpau.pokeshopk

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat

class ComandaRealitzadaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContentView(R.layout.activity_comanda_realitzada)

        val back: Button = findViewById(R.id.back)
        back.setOnClickListener {
            val intent = Intent(this@ComandaRealitzadaActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}