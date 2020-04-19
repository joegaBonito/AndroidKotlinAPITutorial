package com.example.restapitutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.restapitutorial.model.User
import com.example.restapitutorial.retrofit.ApiService
import com.example.restapitutorial.retrofit.RetrofitClient
import com.example.restapitutorial.retrofit.RetrofitManager
import com.example.restapitutorial.utils.Constants
import com.google.gson.JsonElement
import kotlinx.android.synthetic.main.activity_edit_user.*
import retrofit2.Call
import retrofit2.Response

class EditUserActivity : AppCompatActivity() {
    val TAG: String = "Log"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        var bundle: Bundle ?= intent.extras
        var message = bundle!!.getString("user_id")
        var userId = message!!.toInt()
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

        var call = RetrofitManager.instance.httpCall?.getUser(userId);
        call?.enqueue(object : retrofit2.Callback<JsonElement?>{
            override fun onFailure(call: retrofit2.Call<JsonElement?>, t: Throwable) {
                Log.d(TAG, "RetrofitManager - getTodo() - onFailure() Called /  t:$t")
            }

            override fun onResponse(call: Call<JsonElement?>, response: Response<JsonElement?>) {
                Log.d(TAG, "RetrofitManager - getTodo() - onResponse() Called / response:$response")
                Log.d(TAG, "response.body: ${response.body()}")

                Log.d(TAG, "${response.body()?.asJsonObject?.get("firstName")}")
                Log.d(TAG, "${response.body()?.asJsonObject?.get("lastName")}")
                Log.d(TAG, "${response.body()?.asJsonObject?.get("email")}")

//                var firstUser = User(firstName = response.body()?.asJsonObject?.get("firstName").toString(),
//                    lastName =  response.body()?.asJsonObject?.get("lastName").toString(),
//                    email = response.body()?.asJsonObject?.get("email").toString())

                val userId = response.body()?.asJsonObject?.get("id").toString().toInt()
                var firstName = response.body()?.asJsonObject?.get("firstName").toString()
                var lastName = response.body()?.asJsonObject?.get("lastName").toString()
                var email = response.body()?.asJsonObject?.get("email").toString()

                edit_first_name_input.setText(firstName.replace("\"", ""))
                edit_last_name_input.setText(lastName.replace("\"", ""))
                edit_email_input.setText(email.replace("\"", ""))

                edit_user_btn.setOnClickListener {
                    firstName = edit_first_name_input.text.toString()
                    lastName = edit_last_name_input.text.toString()
                    email = edit_email_input.text.toString()
                    RetrofitManager.instance.updateUser(userId, firstName, lastName, email)
                    finish()
                }
            }
        })

        setContentView(R.layout.activity_edit_user)

    }
}
