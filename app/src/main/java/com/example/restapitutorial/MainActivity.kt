package com.example.restapitutorial

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.restapitutorial.retrofit.ApiService
import com.example.restapitutorial.retrofit.RetrofitClient
import com.example.restapitutorial.retrofit.RetrofitManager
import kotlinx.android.synthetic.main.activity_create_user.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit


class MainActivity : AppCompatActivity() {
    val TAG: String = "Log"
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        get_method_btn.setOnClickListener {
            Log.d(TAG, "Get Method")
            RetrofitManager.instance.getUserPagenate(page_input_edit_text.text.toString().toInt())
        }

        post_method_btn.setOnClickListener {
            Log.d(TAG, "Post Method")
            val intent: Intent = Intent(this, CreateUserActivity::class.java)
            startActivity(intent)
        }

        put_method_btn.setOnClickListener {
            Log.d(TAG, "Put Method")
            val userId = user_id_input_edit_text.text.toString()
            val intent = Intent(this,EditUserActivity::class.java)
            intent.putExtra("user_id",userId)
            startActivity(intent)
        }

        delete_method_btn.setOnClickListener {
            Log.d(TAG, "Delete Method")
            delete_method_btn.setOnClickListener {
                val userId = user_id_input_delete_text.text.toString().toInt()
                RetrofitManager.instance.deleteUser(userId)
            }
        }

//        val retrofit = Retrofit.Builder()
//                .baseUrl("https://jsonplaceholder.typicode.com/")
//                .build()
//
//        val service: ApiService = retrofit.create<ApiService>(ApiService::class.java)
//        val call = service.getUsers()
//        val result = call.execute().body()
//        Log.d(TAG, "MainActivity - onCreate() Called - $result")
    }
}
