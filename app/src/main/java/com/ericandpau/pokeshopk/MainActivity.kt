package com.ericandpau.pokeshopk

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContentView(R.layout.activity_main)

        val botoExplorar: Button = findViewById(R.id.botoCard)

        botoExplorar.setOnClickListener {
            val intent = Intent(this@MainActivity, ProductsActivity::class.java)
            startActivity(intent)
        }
    }
}