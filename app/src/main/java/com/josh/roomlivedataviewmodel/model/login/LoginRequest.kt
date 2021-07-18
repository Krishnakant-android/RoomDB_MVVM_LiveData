package com.urdhvam.model.login_model

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("mobile_no")
    var mobileNo: String = "",

    @SerializedName("country_code")
    var countryCode: String = ""
)