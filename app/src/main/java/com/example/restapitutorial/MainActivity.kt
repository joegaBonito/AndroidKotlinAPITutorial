package com.example.restapitutorial

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.restapitutorial.retrofit.ApiService
import com.example.restapitutorial.retrofit.RetrofitClient
import com.example.restapitutorial.retrofit.RetrofitManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit


class MainActivity : AppCompatActivity() {
    val TAG: String = "Log"
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RetrofitManager.instance.getPosts()

        get_method_btn.setOnClickListener {
            Log.d(TAG, "Get Method")
            RetrofitManager.instance.getTodo()
        }

        post_method_btn.setOnClickListener {
            Log.d(TAG, "Post Method")
        }

        put_method_btn.setOnClickListener {
            Log.d(TAG, "Put Method")
        }

        delete_method_btn.setOnClickListener {
            Log.d(TAG, "Delete Method")
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
