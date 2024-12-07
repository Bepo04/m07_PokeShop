package com.ericandpau.pokeshopk

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.ericandpau.pokeshopk.ProductsActivity

class BottomNav : Fragment() {

    private lateinit var exit: Button
    private lateinit var pokes: Button
    private lateinit var help: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bottom_nav, container, false)

        exit = view.findViewById(R.id.exit)
        pokes = view.findViewById(R.id.pokes)
        help = view.findViewById(R.id.help)

        exit.setOnClickListener {
            activity?.finishAffinity()
        }

        pokes.setOnClickListener {
            activity?.let {
                val intent = Intent(it, ProductsActivity::class.java)
                startActivity(intent)
            }
        }

        help.setOnClickListener {
            activity?.let {
                val intent = Intent(it, HelpActivity::class.java)
                startActivity(intent)
            }
        }

        return view
    }
}
