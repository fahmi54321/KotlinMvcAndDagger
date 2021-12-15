package com.android.a2mvcdandagger.common.dependencyinjection.app

import android.app.Application
import com.android.a2mvcdandagger.networking.StackoverflowApi
import dagger.Component
import javax.inject.Singleton

//todo 5 (finish)
@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun application(): Application
    fun stackoverflowApi(): StackoverflowApi

}