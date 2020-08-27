package com.example.pruebatecnica.model


import com.google.gson.annotations.SerializedName

data class ArtistX(
    @SerializedName("mbid")
    val mbid: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)