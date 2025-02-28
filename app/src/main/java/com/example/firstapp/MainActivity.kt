package com.example.firstapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.firstapp.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor =
            ContextCompat.getColor(this, R.color.ligh_purple)


        binding.button.setOnClickListener {
            val name = binding.nameEt.text.toString()
            val email = binding.emailEt.text.toString()
            if (name.isNotEmpty() && email.isNotEmpty()) {
                val intent = Intent(this, Display::class.java)
                intent.putExtra("name", name)
                intent.putExtra("email", email)
                startActivity(intent)
                binding.nameEt.text?.clear()
                binding.emailEt.text?.clear()
            } else {
                Toast.makeText(this, "Please enter both field", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

private fun showBottomSheetDialog(context: Context) {
    val bottomSheetDialog = BottomSheetDialog(context)
    val view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet, null)
    bottomSheetDialog.setContentView(view)

    bottomSheetDialog.setCancelable(true)

    val buttonExit = view.findViewById<ImageView>(R.id.exit)

    buttonExit.setOnClickListener {
        bottomSheetDialog.dismiss() // Close the bottom sheet
    }

    bottomSheetDialog.show()
}