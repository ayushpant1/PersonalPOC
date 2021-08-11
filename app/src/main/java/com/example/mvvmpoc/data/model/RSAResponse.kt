package com.example.mvvmpoc.data.model

import com.google.gson.annotations.SerializedName

data class RSAResponse(
    @SerializedName("Modulus")
    var modulus: String? = null,
    @SerializedName("Exponent")
    val exponent: String? = null,
    @SerializedName("PublicKey")
    val publicKey: String? = null,
    @SerializedName("StatusCode")
    val statusCode: Int? = null,
    @SerializedName("StatusMessage")
    var statusMessage: String? = null


)