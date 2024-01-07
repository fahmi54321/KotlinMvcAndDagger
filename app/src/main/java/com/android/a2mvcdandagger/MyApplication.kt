package com.android.a2mvcdandagger

import android.app.Application
import com.android.a2mvcdandagger.common.dependencyinjection.AppComponent
import com.android.a2mvcdandagger.common.dependencyinjection.AppModule
import com.android.a2mvcdandagger.common.dependencyinjection.DaggerAppComponent

class MyApplication: Application() {

    public val appComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
    }

}