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
import com.example.pruebatecnica.model.TrackDB

class TrackAdapter:RecyclerView.Adapter<TrackAdapter.ViewHolder>() {

    private val ListTrack =  ArrayList<TrackDB>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_track, parent, false)
        )

    override fun getItemCount() = ListTrack.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val track = ListTrack[position]

        holder.tvItemTrackName.text = track.name
        holder.tvItemArtistName.text = track.artist


            Glide.with(holder.ivItemImage.context)
                .load(track.image)
                .apply(RequestOptions.circleCropTransform())
                .into(holder.ivItemImage)


    }

    fun updateData(data: List<TrackDB>){
        ListTrack.clear()
        ListTrack.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val ivItemImage: ImageView = itemView.findViewById(R.id.ivTrack)
        val tvItemTrackName:TextView = itemView.findViewById(R.id.tvItemNameTrack)
        val tvItemArtistName:TextView = itemView.findViewById(R.id.tvItemArtistTrack)
    }

}