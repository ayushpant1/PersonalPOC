package com.example.mvvmpoc.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mvvmpoc.data.model.RSARequest
import com.example.mvvmpoc.data.model.RSAResponse
import com.example.mvvmpoc.data.repository.MainRepository
import com.example.mvvmpoc.utils.Resource
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    fun rsaRequest(rSARequest: RSARequest) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            val rSAResponse: RSAResponse = mainRepository.getRsaResponse(rSARequest)
            if (rSAResponse.statusCode == 200) {
                emit(Resource.success(data = mainRepository.getRsaResponse(rSARequest)))
            } else {
                emit(
                    Resource.failureMessage(
                        data = null,
                        message = rSAResponse.statusMessage ?: "Error Occurred!"
                    )
                )
            }
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }

    }
}