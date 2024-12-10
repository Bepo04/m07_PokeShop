package com.ericandpau.pokeshopk

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment

class NavBar : Fragment() {

    private lateinit var loginButton: Button
    private lateinit var mainButton: Button
    private lateinit var carretoButton: Button
    private lateinit var menuButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_nav_bar, container, false)

        loginButton = view.findViewById(R.id.login)
        mainButton = view.findViewById(R.id.inici)
        menuButton = view.findViewById(R.id.hamburgesa)
        carretoButton = view.findViewById(R.id.cart)

        carretoButton.setOnClickListener {
            val intent = Intent(activity, CarretoActivity::class.java)
            startActivity(intent)
        }

        menuButton.setOnClickListener {
            val intent = Intent(activity, com.ericandpau.pokeshopk.Menu::class.java)
            startActivity(intent)
        }

        mainButton.setOnClickListener {
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        }

        activity?.intent?.let { intent ->
            if (intent.getBooleanExtra("Loged", false)) {
                loginButton.text = "Perfil"
                loginButton.setOnClickListener {
                    val profileIntent = Intent(activity, SettingsActivity::class.java)
                    startActivity(profileIntent)
                }
            } else {
                loginButton.text = "Login"
                loginButton.setOnClickListener {
                    val loginIntent = Intent(activity, Login::class.java)
                    startActivity(loginIntent)
                }
            }
        }

        return view
    }
}
