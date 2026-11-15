package com.example.studentroute

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class alerts : Fragment(R.layout.fragment_alerts) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mainActivity = activity as? MainActivity ?: return
        val prefs = requireContext().getSharedPreferences("StudentRoutePrefs", Context.MODE_PRIVATE)

        val etSavedHome = view.findViewById<EditText>(R.id.etSavedHome)
        val btnSaveHome = view.findViewById<Button>(R.id.btnSaveHome)
        val btnGoHome = view.findViewById<Button>(R.id.btnGoHome)

        etSavedHome.setText(prefs.getString("home_address", ""))

        btnSaveHome.setOnClickListener {
            val homeAddress = etSavedHome.text.toString().trim()
            if (homeAddress.isEmpty()) {
                Toast.makeText(requireContext(), "Enter an address to save", Toast.LENGTH_SHORT).show()
            } else {
                prefs.edit().putString("home_address", homeAddress).apply()
                Toast.makeText(requireContext(), "Home address saved!", Toast.LENGTH_SHORT).show()
            }
        }

        btnGoHome.setOnClickListener {
            val homeAddress = etSavedHome.text.toString().trim()
            if (homeAddress.isEmpty()) {
                Toast.makeText(requireContext(), "Save your Home address first", Toast.LENGTH_SHORT).show()
            } else {
                mainActivity.openGoogleMapsDirections(homeAddress)
            }
        }

        view.findViewById<Button>(R.id.btnCallDrrmo).setOnClickListener {
            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:0344323879")))
        }

        view.findViewById<Button>(R.id.btnCallRedCross).setOnClickListener {
            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:0344348541")))
        }
    }
}