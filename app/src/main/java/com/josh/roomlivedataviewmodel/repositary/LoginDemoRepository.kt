package com.urdhvam.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.urdhvam.model.login_model.LoginRequest
import com.urdhvam.model.login_model.LoginResponse
import com.urdhvam.network.Resource
import com.urdhvam.network.RetrofitApiClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

object LoginDemoRepository : BaseRepository() {

    // create otp
    fun performLogin(data: MutableLiveData<Resource<LoginResponse>>, loginRequest: LoginRequest
    ): LiveData<Resource<LoginResponse>> {

        var exception: Exception? = null

        // For Ui to Show Progress
        data.postValue(Resource.loading(null))

        // Actual Api Call using Coroutine
        CoroutineScope(Dispatchers.IO).launch {
            var response: Response<LoginResponse>? = null
            try {
                response = RetrofitApiClient.getNetworkServices().doLogin(loginRequest)
            } catch (e: Exception) {
                exception = Exception("{ \"error\" : \"Something went Wrong\"}")
            }
            withContext(Dispatchers.Main) {
                data.postValue(handleResponse(
                    if (response == null) null else response as Response<Any>,
                    exception
                ) as Resource<LoginResponse>)
            }
        }
        return data
    }
}