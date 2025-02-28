package com.example.firstapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import com.example.firstapp.R
import com.google.android.material.button.MaterialButton

class Second : Fragment(R.layout.fragment_second) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<MaterialButton>(R.id.button)
        val exit = view.findViewById<ImageView>(R.id.exit)
        exit.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        button.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragContainer, Third())
                .addToBackStack(null)
                .commit()
        }
    }

    /*override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }*/
}