package com.ericandpau.pokeshopk

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat

class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContentView(R.layout.activity_register)

        val intent = Intent(this , MainActivity::class.java)

        val buttonRegister: Button = findViewById(R.id.buttonRegistrar)
        val imageViewPikachu: ImageView = findViewById(R.id.imageViewPikachu)
        val textViewStatus: TextView = findViewById(R.id.textViewStatus)
        val buttonReturnHome: Button = findViewById(R.id.buttonReturnHome)

        buttonRegister.setOnClickListener {
            textViewStatus.text = "Registre completat!"
            imageViewPikachu.visibility = ImageView.VISIBLE
            textViewStatus.visibility = TextView.VISIBLE
            buttonReturnHome.visibility = Button.VISIBLE
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
