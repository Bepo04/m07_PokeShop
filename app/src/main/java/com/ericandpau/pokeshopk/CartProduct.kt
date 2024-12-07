package com.ericandpau.pokeshopk
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class CartProduct : Fragment() {

    private var q: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cart_product, container, false)

        val addButton: Button = view.findViewById(R.id.afegeix)
        val quitButton: Button = view.findViewById(R.id.treu)
        val quantity: TextView = view.findViewById(R.id.quantity)

        quantity.text = q.toString()

        addButton.setOnClickListener {
            q++
            quantity.text = q.toString()
        }

        quitButton.setOnClickListener {
            if (q > 1) {
                q--
            }
            quantity.text = q.toString()
        }

        return view
    }
}
