package com.ericandpau.pokeshopk

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.ericandpau.pokeshopk.validation.RegisterValidator
import com.ericandpau.pokeshopk.viewmodels.RegistreViewModel

class Register : AppCompatActivity() {

    private val viewModel: RegistreViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContentView(R.layout.activity_register)

        val intent = Intent(this, MainActivity::class.java)

        val buttonRegister: Button = findViewById(R.id.buttonRegistrar)
        val imageViewPikachu: ImageView = findViewById(R.id.imageViewPikachu)
        val textViewStatus: TextView = findViewById(R.id.textViewStatus)
        val buttonReturnHome: Button = findViewById(R.id.buttonReturnHome)

        val textViewError: TextView = findViewById(R.id.textViewError)

        val username: EditText = findViewById(R.id.editTextUserName)
        val nom: EditText = findViewById(R.id.editTextNom)
        val cognom: EditText = findViewById(R.id.editTextCognom)
        val correu: EditText = findViewById(R.id.editTextEmail)
        val adreca: EditText = findViewById(R.id.editTextAdreca)
        val codiPostal: EditText = findViewById(R.id.editTextCP)
        val telefon: EditText = findViewById(R.id.editTextTelefon)
        val pswd: EditText = findViewById(R.id.editTextPswd)
        val pswdConf: EditText = findViewById(R.id.editTextPswdConf)

        viewModel.errorNomUsuari.observe(this) {
            if (it.isNotEmpty()) textViewError.text = it
        }
        viewModel.errorNom.observe(this) {
            if (it.isNotEmpty()) textViewError.text = it
        }
        viewModel.errorCognom.observe(this) {
            if (it.isNotEmpty()) textViewError.text = it
        }
        viewModel.errorEmail.observe(this) {
            if (it.isNotEmpty()) textViewError.text = it
        }
        viewModel.errorAdresa.observe(this) {
            if (it.isNotEmpty()) textViewError.text = it
        }
        viewModel.errorCodPostal.observe(this) {
            if (it.isNotEmpty()) textViewError.text = it
        }
        viewModel.errorTelf.observe(this) {
            if (it.isNotEmpty()) textViewError.text = it
        }
        viewModel.errorPassword.observe(this) {
            if (it.isNotEmpty()) textViewError.text = it
        }
        viewModel.errorPswdConfirmation.observe(this) {
            if (it.isNotEmpty()) textViewError.text = it
        }

        // Register button click
        buttonRegister.setOnClickListener {
            textViewError.text = ""

            // Set values in ViewModel
            viewModel.setNomUsuari(username.text.toString())
            viewModel.setNom(nom.text.toString())
            viewModel.setCognom(cognom.text.toString())
            viewModel.setEmail(correu.text.toString())
            viewModel.setAdresa(adreca.text.toString())
            viewModel.setCodPostal(codiPostal.text.toString())
            viewModel.setTelf(telefon.text.toString())
            viewModel.setPassword(pswd.text.toString())
            viewModel.setPswdConfirmation(pswdConf.text.toString())

            // Validate
            viewModel.actualitzaNomUsuari()
            viewModel.actualitzaNom()
            viewModel.actualitzaCognom()
            viewModel.actualitzaCorreu()
            viewModel.actualitzaAdreca()
            viewModel.actualitzaCodiPostal()
            viewModel.actualitzaTelefon()
            viewModel.actualitzaContrassenya()
            viewModel.comparaContrassenyes()

            // Si no hay errores visibles, se muestra éxito
            if (viewModel.errorNomUsuari.value.isNullOrEmpty() &&
                viewModel.errorNom.value.isNullOrEmpty() &&
                viewModel.errorCognom.value.isNullOrEmpty() &&
                viewModel.errorEmail.value.isNullOrEmpty() &&
                viewModel.errorAdresa.value.isNullOrEmpty() &&
                viewModel.errorCodPostal.value.isNullOrEmpty() &&
                viewModel.errorTelf.value.isNullOrEmpty() &&
                viewModel.errorPassword.value.isNullOrEmpty() &&
                viewModel.errorPswdConfirmation.value.isNullOrEmpty()
            ) {
                textViewError.text = ""
                textViewStatus.text = "Registre completat!"
                imageViewPikachu.visibility = ImageView.VISIBLE
                textViewStatus.visibility = TextView.VISIBLE
                buttonReturnHome.visibility = Button.VISIBLE
            } else {
                textViewError.visibility = TextView.VISIBLE
            }
        }

        buttonReturnHome.setOnClickListener {
            startActivity(intent)
        }
    }
}

