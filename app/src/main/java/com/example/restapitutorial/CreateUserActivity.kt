package com.example.restapitutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.restapitutorial.retrofit.RetrofitManager
import kotlinx.android.synthetic.main.activity_create_user.*

class CreateUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Connects with the layout.
        setContentView(R.layout.activity_create_user)

        //When Create User button is clicked.
        create_user_btn.setOnClickListener {
            RetrofitManager.instance.getAllUsers()
            val firstNameInput = first_name_input.text.toString()
            val lastNameInput = last_name_input.text.toString()
            val emailInput = email_input.text.toString()
            RetrofitManager.instance.createUser(firstNameInput, lastNameInput ,emailInput)
            finish()
        }
    }
}
