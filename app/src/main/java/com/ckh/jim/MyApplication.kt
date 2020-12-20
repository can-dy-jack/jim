package com.ckh.jim

import android.app.Application
import android.content.Context
import com.umeng.commonsdk.UMConfigure

class MyApplication: Application() {

    companion object {
        lateinit var context: Context
    }


    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        UMConfigure.init(context, "5fc99c45094d637f31345988", "", UMConfigure.DEVICE_TYPE_PHONE, "")
    }
}