package com.ericandpau.pokeshopk

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.ericandpau.pokeshopk.ProductsActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNav : Fragment() {

    private lateinit var bottomNavView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bottom_nav, container, false)

        bottomNavView = view.findViewById(R.id.bottom_nav)

        bottomNavView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.botmenu_exit -> {
                    activity?.finishAffinity()
                    true
                }
                R.id.botmenu_pokes -> {
                    activity?.let {
                        val intent = Intent(it, ProductsActivity::class.java)
                        startActivity(intent)
                    }
                    true
                }
                R.id.botmenu_help -> {
                    activity?.let {
                        val intent = Intent(it, HelpActivity::class.java)
                        startActivity(intent)
                    }
                    true
                }
                else -> false
            }
        }

        return view
    }
}
