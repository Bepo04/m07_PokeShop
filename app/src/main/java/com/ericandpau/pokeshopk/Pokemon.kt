package com.ericandpau.pokeshopk

import com.google.gson.annotations.SerializedName

data class Pokemon (

    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("nom")
    val nom: String,
    @SerializedName("tipo")
    val tipo: String,
    @SerializedName("altura")
    val altura: Int,
    @SerializedName("img")
    val imgUrl: String
)