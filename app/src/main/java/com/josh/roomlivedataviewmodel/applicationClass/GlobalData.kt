package com.urdhvam.appClass

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.urdhvam.network.RetrofitApiClient

class GlobalData : Application() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var mAppContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        RetrofitApiClient.getRetrofitClient()
        mAppContext = applicationContext
    }
}