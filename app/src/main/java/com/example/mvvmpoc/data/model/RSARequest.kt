package com.example.mvvmpoc.data.model

import com.google.gson.annotations.SerializedName

data class RSARequest(
    @SerializedName("Username")
    val username: String
)