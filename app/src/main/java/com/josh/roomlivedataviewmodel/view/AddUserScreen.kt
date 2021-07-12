package com.josh.roomlivedataviewmodel.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.josh.roomlivedataviewmodel.R
import com.josh.roomlivedataviewmodel.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login_screen.*

class AddUserScreen : AppCompatActivity() {
    lateinit var loginViewModel: LoginViewModel

    lateinit var context: Context

    lateinit var strUsername: String
    lateinit var strPassword: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user_screen)

        context = this@AddUserScreen

        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        btnAddLogin.setOnClickListener {

            strUsername = txtUsername.text.toString().trim()
            strPassword = txtPassword.text.toString().trim()

            if (strPassword.isEmpty()) {
                txtUsername.error = "Please enter the username"
            } else if (strPassword.isEmpty()) {
                txtPassword.error = "Please enter the username"
            } else {
                loginViewModel.insertData(context, strUsername, strPassword)
                Toast.makeText(context, "User Inserted Successfully", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}