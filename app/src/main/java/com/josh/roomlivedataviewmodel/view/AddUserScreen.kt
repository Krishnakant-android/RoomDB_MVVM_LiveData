package com.josh.roomlivedataviewmodel.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.josh.roomlivedataviewmodel.R
import com.josh.roomlivedataviewmodel.viewmodel.LoginViewModel
import com.urdhvam.appClass.BaseActivity
import com.urdhvam.network.Resource
import kotlinx.android.synthetic.main.activity_add_user_screen.*

class AddUserScreen : BaseActivity() {
    lateinit var loginViewModel: LoginViewModel


    lateinit var context: Context

    lateinit var strUsername: String
    lateinit var strPassword: String

    override fun getLayoutId(): Int {
        return R.layout.activity_add_user_screen
    }

    override fun initializeViewModel() {
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
    }


    override fun init() {
        context = this@AddUserScreen
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

//                loginViewModel.performLogin(loginRequest).observe(this@AddUserScreen, Observer {
//                    when (it.status) {
////                        Resource.Status.SUCCESS -> handleSuccess(loginRequest.mobileNo, it)
//                        Resource.Status.LOADING -> showLoader()
//                        Resource.Status.ERROR -> showError(it.exception)
//                    }
//                })
            }
        }
    }

//    private fun handleSuccess(mobileNo : String , it: Resource<LoginResponse>?) {
//        hideLoader()
//        val responseData = it!!.data!!
//        navigateToOTPverification(mobileNo, responseData)
//    }


}