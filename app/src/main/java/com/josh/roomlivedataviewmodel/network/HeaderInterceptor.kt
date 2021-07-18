package com.urdhvam.network

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain?): Response {

        val request = chain?.request()?.newBuilder()
//            ?.addHeader("Content-Type", ApplicationConstant.CONTENT_TYPE)
//            ?.addHeader("Accept", ApplicationConstant.ACCEPT_TYPE)
//            ?.addHeader("Device-Id", AppSharedPreferences.getStringValue(AppSharedPreferences.DEVICE_KEY))
//            ?.addHeader("Authorization", AppSharedPreferences.getStringValue(AppSharedPreferences.AUTH_TOKEN))
            ?.build()
            ?: chain?.request()
                ?.newBuilder()
                ?.build()


        return chain?.proceed(request)!!
    }

}