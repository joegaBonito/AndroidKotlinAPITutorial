package com.example.restapitutorial.retrofit

import android.util.Log
import com.google.gson.JsonElement

class RetrofitManager {

    val TAG: String = "Log"

    companion object{
        val instance = RetrofitManager()
    }

    private val httpCall : ApiService? = RetrofitClient.getClient("https://jsonplaceholder.typicode.com/")?.create(ApiService::class.java)

    fun getPosts() {
        var call = httpCall?.getPosts();
        call?.enqueue(object : retrofit2.Callback<JsonElement?>{
            override fun onFailure(call: retrofit2.Call<JsonElement?>, t: Throwable) {
                Log.d(TAG, "RetrofitManager - getPosts() - onFailure() Called /  t:$t")
            }

            override fun onResponse(call: retrofit2.Call<JsonElement?>, response: retrofit2.Response<JsonElement?>) {
                Log.d(TAG, "RetrofitManager - getPosts() - onResponse() Called / response:$response")
                Log.d(TAG, "response.body: ${response.body()}")
            }
        })
    }

    fun getTodo() {
        var call = httpCall?.getTodo();
        call?.enqueue(object : retrofit2.Callback<JsonElement?>{
            override fun onFailure(call: retrofit2.Call<JsonElement?>, t: Throwable) {
                Log.d(TAG, "RetrofitManager - getTodo() - onFailure() Called /  t:$t")
            }

            override fun onResponse(call: retrofit2.Call<JsonElement?>, response: retrofit2.Response<JsonElement?>) {
                Log.d(TAG, "RetrofitManager - getTodo() - onResponse() Called / response:$response")
                Log.d(TAG, "response.body: ${response.body()}")
            }
        })
    }


}