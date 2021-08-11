package com.example.mvvmpoc.data.api

import com.example.mvvmpoc.data.model.RSARequest
import com.example.mvvmpoc.data.model.RSAResponse
import com.example.mvvmpoc.data.model.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    @Headers("Content-Type: application/json")
    @GET("users")
    suspend fun getUsers(): List<User>

    @Headers("Content-Type: application/json")
    @POST("oauth2/key")
    suspend fun rsaResponse(@Body rsaRequest: RSARequest): RSAResponse


}