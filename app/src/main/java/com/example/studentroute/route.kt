package com.example.studentroute

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class route : Fragment(R.layout.fragment_route) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mainActivity = activity as? MainActivity ?: return
        val etSchoolDestination = view.findViewById<EditText>(R.id.etSchoolDestination)
        val btnNavigate = view.findViewById<Button>(R.id.btnNavigate)
        val btnPreset1 = view.findViewById<Button>(R.id.btnPreset1)
        val btnPreset2 = view.findViewById<Button>(R.id.btnPreset2)

        btnNavigate.setOnClickListener {
            val destination = etSchoolDestination.text.toString().trim()
            if (destination.isEmpty()) {
                Toast.makeText(requireContext(), "Please enter a school or destination", Toast.LENGTH_SHORT).show()
            } else {
                mainActivity.openGoogleMapsDirections(destination)
            }
        }

        btnPreset1.setOnClickListener { mainActivity.openGoogleMapsDirections("University of St. La Salle, Bacolod") }
        btnPreset2.setOnClickListener { mainActivity.openGoogleMapsDirections("University of Negros Occidental - Recoletos, Bacolod") }
    }
}