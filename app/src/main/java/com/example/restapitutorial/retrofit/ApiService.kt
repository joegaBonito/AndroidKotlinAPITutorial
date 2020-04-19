package com.example.restapitutorial.retrofit

import com.example.restapitutorial.utils.Constants.API_DELETE_USER
import com.example.restapitutorial.utils.Constants.API_GET_USER
import com.example.restapitutorial.utils.Constants.API_UPDATE_USER
import com.example.restapitutorial.utils.Constants.API_USER
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.*


interface ApiService {

    @GET(API_USER)
    fun getAllUsers(): Call<JsonElement>?

    @GET(API_GET_USER)
    fun getUser(@Path(value = "page",encoded= true) userId:Int): Call<JsonElement>?

    //id,firstName,lastName,email
    @FormUrlEncoded
    @POST(API_USER)
    fun createUser(@Field("firstName") firstName:String, @Field("lastName") lastName:String, @Field("email") email:String) : Call<JsonElement>?

    @FormUrlEncoded
    @PUT(API_UPDATE_USER)
    fun updateUser(@Path("id") id: Int, @Field("firstName") firstName:String, @Field("lastName") lastName:String, @Field("email") email:String) : Call<JsonElement>?

    @DELETE(API_DELETE_USER)
    fun deleteUser(@Path("id") id: Int) : Call<JsonElement>?
}