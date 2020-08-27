package com.example.pruebatecnica.model


import com.google.gson.annotations.SerializedName

data class TopTracks(
    @SerializedName("tracks")
    val tracks: Tracks
)