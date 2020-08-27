package com.example.pruebatecnica.model


import com.google.gson.annotations.SerializedName

data class Tracks(
    @SerializedName("@attr")
    val attr: AttrX,
    @SerializedName("track")
    val track: List<Track>
)