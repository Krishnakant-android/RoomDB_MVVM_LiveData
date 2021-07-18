package com.urdhvam.model.login_model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("message")
    val message: String,

    @SerializedName("data")
    val data: LoginResponseData

)

data class LoginResponseData(
    @SerializedName("otp")
    val otp: String,

    @SerializedName("token")
    val token: String


)