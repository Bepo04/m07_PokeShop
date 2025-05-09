package com.ericandpau.pokeshopk

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.ericandpau.pokeshopk.validation.LoginValidator
import com.ericandpau.pokeshopk.viewmodels.LoginViewModel

class Login : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var button2: Button

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContentView(R.layout.activity_login)

        button = findViewById(R.id.callback)
        button2 = findViewById(R.id.registre)

        val mail: EditText = findViewById(R.id.editTextTextEmailAddress)
        val password: EditText = findViewById(R.id.editTextTextPassword)
        val textViewError: TextView = findViewById(R.id.textViewLoginError)

        viewModel.errorMail.observe(this) { error ->
            if (error.isNotEmpty()) {
                textViewError.text = error
                textViewError.visibility = TextView.VISIBLE
            } else {
                textViewError.visibility = TextView.GONE
            }
        }

        viewModel.errorPassword.observe(this) { error ->
            if (error.isNotEmpty()) {
                textViewError.text = error
                textViewError.visibility = TextView.VISIBLE
            } else {
                textViewError.visibility = TextView.GONE
            }
        }

        button.setOnClickListener {
            val emailInput = mail.text.toString()
            val passwordInput = password.text.toString()

            viewModel.setMail(emailInput)
            viewModel.setPassword(passwordInput)

            viewModel.comprovaEmail()
            viewModel.comprovaContrasenya()

            if (viewModel.errorMail.value.isNullOrEmpty() && viewModel.errorPassword.value.isNullOrEmpty()) {
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