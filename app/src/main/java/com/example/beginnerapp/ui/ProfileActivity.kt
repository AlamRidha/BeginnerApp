package com.example.beginnerapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.beginnerapp.R
import com.example.beginnerapp.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}