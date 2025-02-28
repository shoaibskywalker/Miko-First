package com.example.firstapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.firstapp.adapter.User
import com.example.firstapp.adapter.UserAdapter
import com.example.firstapp.databinding.ActivityDisplayBinding

class Display : AppCompatActivity() {

    private lateinit var binding: ActivityDisplayBinding
    lateinit var mAdapter: UserAdapter
    private lateinit var userList: ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor =
            ContextCompat.getColor(this, R.color.ligh_purple)

        binding.imageBack.setOnClickListener {
            finish()
        }

        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")

        binding.displayName.text = name.toString()
        binding.displayEmail.text = "($email)"
    }
}