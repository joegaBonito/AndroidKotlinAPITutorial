package com.example.restapitutorial.retrofit

import android.content.Intent
import android.util.Log
import com.example.restapitutorial.EditUserActivity
import com.example.restapitutorial.model.User
import com.example.restapitutorial.utils.Constants.API_BASE_URL
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Response

class RetrofitManager {

    val TAG: String = "Log"

    companion object{
        val instance = RetrofitManager()
    }

    val httpCall : ApiService? = RetrofitClient.getClient(API_BASE_URL)?.create(ApiService::class.java)

    fun getAllUsers() {
        var call = httpCall?.getAllUsers();
        call?.enqueue(object : retrofit2.Callback<JsonElement?>{
            override fun onFailure(call: retrofit2.Call<JsonElement?>, t: Throwable) {
                Log.d(TAG, "RetrofitManager - getTodo() - onFailure() Called /  t:$t")
            }

            override fun onResponse(call: Call<JsonElement?>, response: Response<JsonElement?>) {
                Log.d(TAG, "RetrofitManager - getTodo() - onResponse() Called / response:$response")
                Log.d(TAG, "response.body: ${response.body()}")
            }
        })
    }

    fun getUserPagenate(page: Int) {
        var call = httpCall?.getUser(page);
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

    fun createUser(firstName:String, lastName:String, email:String) {
        val call = httpCall?.createUser(firstName,lastName,email)
        call?.enqueue(object : retrofit2.Callback<JsonElement> {
            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                Log.d(TAG, "RetrofitManager - getTodo() - onFailure() Called /  t:$t")
            }

            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                Log.d(TAG, "RetrofitManager - getTodo() - onResponse() Called / response:$response")
                Log.d(TAG, "response.body: ${response.body()}")
            }

        })

    }

    fun updateUser(id: Int,firstName:String, lastName:String, email:String) {
        var call = httpCall?.updateUser(id, firstName, lastName, email);
        call?.enqueue(object : retrofit2.Callback<JsonElement?>{
            override fun onFailure(call: retrofit2.Call<JsonElement?>, t: Throwable) {
                Log.d(TAG, "RetrofitManager - updateUser() - onFailure() Called /  t:$t")
            }

            override fun onResponse(call: retrofit2.Call<JsonElement?>, response: retrofit2.Response<JsonElement?>) {
                Log.d(TAG, "RetrofitManager - updateUser() - onResponse() Called / response:$response")
                Log.d(TAG, "response.body: ${response.body()}")
            }
        })
    }

    fun deleteUser(id:Int) {
        var call = httpCall?.deleteUser(id);
        call?.enqueue(object : retrofit2.Callback<JsonElement?>{
            override fun onFailure(call: Call<JsonElement?>, t: Throwable) {
                Log.d(TAG, "RetrofitManager - deleteUser() - onFailure() Called /  t:$t")
            }

            override fun onResponse(call: Call<JsonElement?>, response: Response<JsonElement?>) {
                Log.d(TAG, "RetrofitManager - deleteUser() - onResponse() Called / response:$response")
                Log.d(TAG, "response.body: ${response.body()}")
            }
        })
    }
}
