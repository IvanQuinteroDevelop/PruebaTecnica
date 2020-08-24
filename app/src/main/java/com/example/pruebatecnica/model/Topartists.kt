package com.example.pruebatecnica.model


import com.google.gson.annotations.SerializedName

data class Topartists(
    @SerializedName("artist")
    val artist: List<Artist>,
    @SerializedName("@attr")
    val attr: Attr
)