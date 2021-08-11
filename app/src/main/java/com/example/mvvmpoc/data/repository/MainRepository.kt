package com.example.mvvmpoc.data.repository

import com.example.mvvmpoc.data.api.ApiHelper
import com.example.mvvmpoc.data.model.RSARequest

class MainRepository(private val apiHelper: ApiHelper) {
    suspend fun getUsers() = apiHelper.getUsers()
    suspend fun getRsaResponse(rSARequest: RSARequest) = apiHelper.getResponse(rSARequest)
//    suspend fun getPopularBlog(rSARequest: RSARequest) = apiHelper.getPopularBlog(rSARequest)



}