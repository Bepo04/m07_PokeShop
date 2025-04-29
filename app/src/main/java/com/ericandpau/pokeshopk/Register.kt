package com.ericandpau.pokeshopk

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.ericandpau.pokeshopk.validation.RegisterValidator

class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContentView(R.layout.activity_register)

        val intent = Intent(this, MainActivity::class.java)

        val buttonRegister: Button = findViewById(R.id.buttonRegistrar)
        val imageViewPikachu: ImageView = findViewById(R.id.imageViewPikachu)
        val textViewStatus: TextView = findViewById(R.id.textViewStatus)
        val buttonReturnHome: Button = findViewById(R.id.buttonReturnHome)

        val username: EditText = findViewById(R.id.editTextUserName)
        val nom: EditText = findViewById(R.id.editTextNom)
        val cognom: EditText = findViewById(R.id.editTextCognom)
        val correu: EditText = findViewById(R.id.editTextEmail)
        val adreca: EditText = findViewById(R.id.editTextAdreca)
        val codiPostal: EditText = findViewById(R.id.editTextCP)
        val telefon: EditText = findViewById(R.id.editTextTelefon)

        buttonRegister.setOnClickListener {
            // Validem camps
            val errors = listOfNotNull(
                RegisterValidator.actualitzaNomUsuari(username.text.toString()),
                RegisterValidator.actualitzaNom(nom.text.toString()),
                RegisterValidator.actualitzaCognom(cognom.text.toString()),
                RegisterValidator.actualitzaCorreu(correu.text.toString()),
                RegisterValidator.actualitzaAdreca(adreca.text.toString()),
                RegisterValidator.actualitzaCodiPostal(codiPostal.text.toString()),
                RegisterValidator.actualitzaTelefon(telefon.text.toString()),
            )

            if (errors.isNotEmpty()) {
                Toast.makeText(this, errors.first(), Toast.LENGTH_SHORT).show()
            } else {
                textViewStatus.text = "Registre completat!"
                imageViewPikachu.visibility = ImageView.VISIBLE
                textViewStatus.visibility = TextView.VISIBLE
                buttonReturnHome.visibility = Button.VISIBLE
            }
        }

        buttonReturnHome.setOnClickListener {
            textViewStatus.text = ""
            imageViewPikachu.visibility = ImageView.GONE
            textViewStatus.visibility = TextView.GONE
            buttonReturnHome.visibility = Button.GONE

            startActivity(intent)
        }
    }
}
