package com.example.pruebatecnica.model


import com.google.gson.annotations.SerializedName

data class Track(
    @SerializedName("artist")
    val artist: ArtistX,
    @SerializedName("@attr")
    val attr: AttrXX,
    @SerializedName("duration")
    val duration: String,
    @SerializedName("image")
    val image: List<Image>,
    @SerializedName("listeners")
    val listeners: String,
    @SerializedName("mbid")
    val mbid: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("streamable")
    val streamable: Streamable,
    @SerializedName("url")
    val url: String
)