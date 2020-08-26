package com.example.pruebatecnica.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.pruebatecnica.R
import com.example.pruebatecnica.model.Artist
import kotlinx.android.synthetic.main.item_artist.view.*

class ArtistAdapter():RecyclerView.Adapter<ArtistAdapter.ViewHolder>() {

    val listArtist =  ArrayList<Artist>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_artist, parent, false)
    )

    override fun getItemCount() = listArtist.size

    override fun onBindViewHolder(holder: ArtistAdapter.ViewHolder, position: Int) {
        val artist = listArtist[position]

        holder.tvItemArtist.text = artist.name
        holder.tvItemListeners.text = "${artist.listeners} Reproducciones"

        artist.image.forEach {
            Glide.with(holder.ivItemImage.context)
                .load(it.text)
                //.apply(RequestOptions.circleCropTransform())
                .into(holder.ivItemImage)
        }

    }

    fun updateData(data: List<Artist>){
        listArtist.clear()
        listArtist.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val ivItemImage = itemView.findViewById<ImageView>(R.id.ivItemArtist)
        val tvItemArtist = itemView.findViewById<TextView>(R.id.tvItemArtist)
        val tvItemListeners = itemView.findViewById<TextView>(R.id.tvItemListeners)
    }

}