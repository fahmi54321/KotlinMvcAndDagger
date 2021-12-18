package com.android.a2mvcdandagger.common.service

import android.app.Service
import com.android.a2mvcdandagger.MyApplication
import com.android.a2mvcdandagger.common.dependencyinjection.activity.ActivityModule
import com.android.a2mvcdandagger.common.dependencyinjection.service.ServiceModule

//todo 4 (finish)
abstract class BaseService : Service() {

    private val appComponent get() = (application as MyApplication).appComponent

    val serviceComponent by lazy {
        appComponent.newServiceCompononent(ServiceModule(this))
    }

}