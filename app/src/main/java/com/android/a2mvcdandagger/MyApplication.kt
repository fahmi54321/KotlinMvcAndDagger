package com.android.a2mvcdandagger

import android.app.Application
import com.android.a2mvcdandagger.common.dependencyinjection.app.AppModule
import com.android.a2mvcdandagger.common.dependencyinjection.app.DaggerAppComponent

class MyApplication: Application() {

    val appComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
    }

}