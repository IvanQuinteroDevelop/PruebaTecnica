package com.example.pruebatecnica.model


import com.google.gson.annotations.SerializedName

data class Artist(
    @SerializedName("image")
    val image: List<Image>,
    @SerializedName("listeners")
    val listeners: String,
    @SerializedName("mbid")
    val mbid: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("streamable")
    val streamable: String,
    @SerializedName("url")
    val url: String
)