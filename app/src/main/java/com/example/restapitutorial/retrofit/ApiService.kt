package com.example.restapitutorial.retrofit

import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET


interface ApiService {

    @GET("posts")
    fun getPosts(): Call<JsonElement>?

    @GET("todos/1")
    fun getTodo(): Call<JsonElement>?

}