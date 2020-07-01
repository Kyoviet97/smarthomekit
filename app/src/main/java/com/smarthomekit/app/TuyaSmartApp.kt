package com.smarthomekit.app

import android.app.Activity
import android.app.Application
import android.content.Intent
import com.tuya.smart.home.sdk.TuyaHomeSdk


class TuyaSmartApp: Application(){
    override fun onCreate() {
        super.onCreate()
        TuyaHomeSdk.setDebugMode(true)
        TuyaHomeSdk.init(this)
        TuyaHomeSdk.setOnNeedLoginListener { context ->
            val intent = Intent(context, MainActivity::class.java)
            if (context !is Activity) {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            startActivity(intent)
        }
    }
}