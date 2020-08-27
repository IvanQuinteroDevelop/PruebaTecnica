package com.example.pruebatecnica.model


import com.google.gson.annotations.SerializedName

data class TopArtist(
    @SerializedName("topartists")
    val topArtists: Topartists
)