package com.urdhvam.network
import com.urdhvam.model.login_model.LoginRequest
import com.urdhvam.model.login_model.LoginResponse
import retrofit2.Response
import retrofit2.http.*

interface NetworkServices {

//     create otp
    @POST("/generate_otp.json")
    suspend fun doLogin(@Body loginRequest: LoginRequest): Response<LoginResponse>

}