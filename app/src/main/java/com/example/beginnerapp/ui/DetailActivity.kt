package com.example.beginnerapp.ui

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.beginnerapp.R
import com.example.beginnerapp.data.Player
import com.example.beginnerapp.databinding.ActivityDetailBinding
import com.example.beginnerapp.ui.MainActivity.Companion.EXTRA_PLAYER

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val player = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_PLAYER, Player::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_PLAYER)
        }
        //  cek data from main activity
        Log.d(TAG, "data adalah $player")

        binding.apply {
            if (player != null) {
                tvDetailName.text = player.name
                tvDetailDescription.text = player.description
                Glide.with(this@DetailActivity).load(player.photo).into(ivDetailPhoto)
            }
        }
    }

    companion object {
        const val TAG = "DetailActivity"
    }
}