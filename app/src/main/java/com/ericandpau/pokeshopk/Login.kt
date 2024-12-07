package com.ericandpau.pokeshopk

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat

class Login : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var button2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContentView(R.layout.activity_login)

        button = findViewById(R.id.callback)
        button2 = findViewById(R.id.registre)

        val mail: EditText = findViewById(R.id.editTextTextEmailAddress)
        val password: EditText = findViewById(R.id.editTextTextPassword)

        button.setOnClickListener {
            if (mail.text.toString().isEmpty() || password.text.toString().isEmpty()) {
                Toast.makeText(this@Login, "Introdueix tots els camps", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this@Login, MainActivity::class.java)
                intent.putExtra("Loged", true)
                startActivity(intent)
            }
        }

        button2.setOnClickListener {
            val intent = Intent(this@Login, Register::class.java)
            startActivity(intent)
        }
    }
}