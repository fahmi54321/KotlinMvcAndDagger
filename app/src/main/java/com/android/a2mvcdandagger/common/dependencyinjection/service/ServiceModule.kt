package com.android.a2mvcdandagger.common.dependencyinjection.service

import android.app.Service
import android.content.Context
import dagger.Module
import dagger.Provides

//todo 1 (next ServiceComponent)
@Module
class ServiceModule(
    val service: Service,
) {

    @Provides
    fun context(): Context = service
}