package com.example.studentroute

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class transit : Fragment(R.layout.fragment_transit) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mainActivity = activity as? MainActivity ?: return

        view.findViewById<Button>(R.id.btnJeep1).setOnClickListener {
            mainActivity.openGoogleMapsDirections("Bata Jeepney Terminal, Bacolod")
        }
        view.findViewById<Button>(R.id.btnJeep2).setOnClickListener {
            mainActivity.openGoogleMapsDirections("Mandalagan Jeepney Stop, Lacson St, Bacolod")
        }
        view.findViewById<Button>(R.id.btnJeep3).setOnClickListener {
            mainActivity.openGoogleMapsDirections("Central Market Jeepney Terminal, Bacolod")
        }
    }
}