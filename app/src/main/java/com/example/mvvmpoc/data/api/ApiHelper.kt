package com.example.mvvmpoc.data.api

import com.example.mvvmpoc.data.model.RSARequest

class ApiHelper(private val apiService: ApiService) {
    suspend fun getUsers() = apiService.getUsers()
    suspend fun getResponse(rSARequest: RSARequest) = apiService.rsaResponse(rSARequest)

}