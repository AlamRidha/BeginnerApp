package com.example.beginnerapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.beginnerapp.R
import com.example.beginnerapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }
}