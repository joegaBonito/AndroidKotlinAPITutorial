package com.example.restapitutorial.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Singleton Pattern to call RESTful service.
object RetrofitClient {

    val TAG: String = "Log"

    private var retrofitClient: Retrofit? = null

    // Retrieve retrofitClient if retrofitClient doesn't exist.
    fun getClient(baseUrl: String): Retrofit? {
        if(retrofitClient == null){
            retrofitClient = Retrofit.Builder()
            .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
            .build()

        }
        return retrofitClient
    }
}