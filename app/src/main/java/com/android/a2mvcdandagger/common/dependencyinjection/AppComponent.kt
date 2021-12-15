package com.android.a2mvcdandagger.common.dependencyinjection

import android.app.Application
import com.android.a2mvcdandagger.networking.StackoverflowApi
import dagger.Component
import dagger.Provides

@Component(modules = [AppModule::class])
interface AppComponent {

    fun application(): Application
    fun stackoverflowApi(): StackoverflowApi

}