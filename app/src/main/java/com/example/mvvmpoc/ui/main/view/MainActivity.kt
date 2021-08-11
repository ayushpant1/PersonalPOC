package com.example.mvvmpoc.ui.main.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmpoc.R
import com.example.mvvmpoc.data.api.ApiHelper
import com.example.mvvmpoc.data.api.RetrofitBuilder
import com.example.mvvmpoc.data.model.RSARequest
import com.example.mvvmpoc.data.model.RSAResponse
import com.example.mvvmpoc.data.model.User
import com.example.mvvmpoc.ui.base.ViewModelFactory
import com.example.mvvmpoc.ui.main.viewmodel.MainViewModel
import com.example.mvvmpoc.utils.BusyIndicator
import com.example.mvvmpoc.utils.Status

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
        setupObservers()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(MainViewModel::class.java)
    }

    private fun setupObservers() {
        val rsaRequest: RSARequest = RSARequest("ayush")
        viewModel.rsaRequest(rsaRequest).observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        resource.data?.let { users -> rsaResponse(users) }
                        BusyIndicator.hideBusyLoader()
                    }
                    Status.ERROR -> {
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                        BusyIndicator.hideBusyLoader()
                    }
                    Status.LOADING -> {
                        BusyIndicator.showBusyLoader(this)
                    }
                    Status.FAILURE_MESSAGE -> {
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                        BusyIndicator.hideBusyLoader()
                    }
                }

            }
        })
    }

    private fun rsaResponse(rsaResponse: RSAResponse) {
        var xx = "";
    }

    private fun retrieveList(users: List<User>) {
        var user1 = users;
        users[0].image
        var xx = "";

    }


}