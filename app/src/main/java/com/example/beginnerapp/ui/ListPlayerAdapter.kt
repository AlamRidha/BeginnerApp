package com.example.beginnerapp.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.beginnerapp.data.Player
import com.example.beginnerapp.databinding.ItemRowPlayerBinding

class ListPlayerAdapter(private val listPlayer: ArrayList<Player>) :
    RecyclerView.Adapter<ListPlayerAdapter.ListViewHolder>() {

    //  declare the variable for click item
    private lateinit var onItemClickCallBack: OnItemClickCallback

    //  make this function for trigger from activity
    fun setOnItemClickCallBack(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallBack = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding =
            ItemRowPlayerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listPlayer.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listPlayer[position]
        Glide.with(holder.itemView.context).load(photo).into(holder.binding.ivPlayerPhoto)
        holder.binding.tvPlayerName.text = name
        holder.binding.tvPlayerDescription.text = description
        holder.itemView.setOnClickListener {
            Log.d(TAG, listPlayer[holder.adapterPosition].name)
            onItemClickCallBack.onItemClicked(listPlayer[holder.adapterPosition])
        }
    }

    class ListViewHolder(var binding: ItemRowPlayerBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    interface OnItemClickCallback {
        //  make function itemclick
        fun onItemClicked(data: Player)
    }

    companion object {
        const val TAG = "Adapter"
    }
}