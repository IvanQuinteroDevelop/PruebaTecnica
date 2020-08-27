package com.example.pruebatecnica.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.pruebatecnica.R
import com.example.pruebatecnica.model.ArtistDB

class ArtistAdapter:RecyclerView.Adapter<ArtistAdapter.ViewHolder>() {

    private val listArtist =  ArrayList<ArtistDB>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_artist, parent, false)
        )

    override fun getItemCount() = listArtist.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val artist = listArtist[position]

        holder.tvItemArtist.text = artist.name
        holder.tvItemListeners.text = "${artist.listeners} Reproducciones"


            Glide.with(holder.ivItemImage.context)
                .load(artist.image)
                .apply(RequestOptions.circleCropTransform())
                .into(holder.ivItemImage)


    }

    fun updateData(data: List<ArtistDB>){
        listArtist.clear()
        listArtist.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val ivItemImage: ImageView = itemView.findViewById(R.id.ivItemArtist)
        val tvItemArtist:TextView = itemView.findViewById(R.id.tvItemArtist)
        val tvItemListeners:TextView = itemView.findViewById(R.id.tvItemListeners)
    }

}