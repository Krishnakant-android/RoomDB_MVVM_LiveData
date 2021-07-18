package com.josh.roomlivedataviewmodel.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.josh.roomlivedataviewmodel.model.LoginTableModel
import com.josh.roomlivedataviewmodel.model.UserModel
import com.josh.roomlivedataviewmodel.repositary.LoginRepository
import com.urdhvam.model.login_model.LoginRequest
import com.urdhvam.model.login_model.LoginResponse
import com.urdhvam.network.Resource
import com.urdhvam.repositories.LoginDemoRepository
import com.urdhvam.viewModel.BaseViewModel

class LoginViewModel : BaseViewModel() {

    var liveDataLogin: LiveData<LoginTableModel>? = null

    fun insertData(context: Context, username: String, password: String) {
       LoginRepository.insertData(context, username, password)
    }

    fun getLoginDetails(context: Context, username: String) : LiveData<LoginTableModel>? {
        liveDataLogin = LoginRepository.getLoginDetails(context, username)
        return liveDataLogin
    }

    fun getAllUsers(context: Context) : LiveData<List<UserModel>> {
        return LoginRepository.getAllUserDetails(context)
    }


    //Get otp
    fun performLogin(loginRequest: LoginRequest): LiveData<Resource<LoginResponse>> {
        return LoginDemoRepository.performLogin(MutableLiveData(), loginRequest)
    }

}