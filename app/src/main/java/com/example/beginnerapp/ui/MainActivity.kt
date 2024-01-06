package com.example.beginnerapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.beginnerapp.R
import com.example.beginnerapp.data.Player
import com.example.beginnerapp.databinding.ActivityMainBinding

// Finish
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val player = ArrayList<Player>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvPlayerNba.setHasFixedSize(true)
        player.addAll(getData())
        showRecycleList()
    }

    //  appbar menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_profile -> {
                val intentAbout = Intent(this@MainActivity, ProfileActivity::class.java)
                startActivity(intentAbout)
            }

            R.id.action_list -> {
                binding.rvPlayerNba.layoutManager = LinearLayoutManager(this)
            }

            R.id.action_grid -> {
                binding.rvPlayerNba.layoutManager = GridLayoutManager(this, 2)
            }
        }
        return super.onOptionsItemSelected(item)
    }


    //  show recycle list
    private fun showRecycleList() {
        binding.rvPlayerNba.layoutManager = LinearLayoutManager(this)
        val listPlayerAdapter = ListPlayerAdapter(player)
        binding.rvPlayerNba.adapter = listPlayerAdapter

        //  click item
        listPlayerAdapter.setOnItemClickCallBack(object : ListPlayerAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Player) {
                val intentDetail = Intent(this@MainActivity, DetailActivity::class.java)
                intentDetail.putExtra(EXTRA_PLAYER, data)
                //  cek data
                Log.d(TAG, data.name)
                startActivity(intentDetail)
            }
        })
    }

    //  getdata from string value
    private fun getData(): ArrayList<Player> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val listPlayer = ArrayList<Player>()

        for (i in dataName.indices) {
            val player = Player(dataName[i], dataDescription[i], dataPhoto[i])
            listPlayer.add(player)
        }

        return listPlayer
    }


    companion object {
        const val TAG = "MainActivity"
        const val EXTRA_PLAYER = "extra_player"
    }

}