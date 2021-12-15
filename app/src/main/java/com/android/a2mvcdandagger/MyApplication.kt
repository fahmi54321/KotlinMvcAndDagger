package com.android.a2mvcdandagger

import android.app.Application
import com.android.a2mvcdandagger.common.dependencyinjection.app.AppModule

class MyApplication: Application() {

    lateinit var appModule: AppModule

    override fun onCreate() {
        appModule = AppModule(this)
        super.onCreate()
    }

}