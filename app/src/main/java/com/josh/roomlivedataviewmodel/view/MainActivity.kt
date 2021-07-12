package com.josh.roomlivedataviewmodel.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.josh.roomlivedataviewmodel.R
import com.josh.roomlivedataviewmodel.adapter.UserAdapter
import com.josh.roomlivedataviewmodel.model.UserModel
import com.josh.roomlivedataviewmodel.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var loginViewModel: LoginViewModel
    lateinit var context: Context
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this@MainActivity
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        loginViewModel.getAllUsers(context).observe(this, {
            userAdapter = UserAdapter(it)
            recyclerViewUserList.layoutManager = LinearLayoutManager(context)
            recyclerViewUserList.adapter = userAdapter
        })

        add_fab.setOnClickListener {
            val intent = Intent(context,AddUserScreen::class.java)
            startActivity(intent)
        }
    }
}