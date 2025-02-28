package com.example.firstapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstapp.fragments.First

class Container : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_container)

        if (savedInstanceState == null) { // Avoid adding fragment again on config change
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragContainer, First())
                .commit()
        }
    }
}