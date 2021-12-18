package com.android.a2mvcdandagger.common.dependencyinjection.app

import android.app.Application
import com.android.a2mvcdandagger.common.dependencyinjection.activity.ActivityComponent
import com.android.a2mvcdandagger.common.dependencyinjection.activity.ActivityModule
import com.android.a2mvcdandagger.common.dependencyinjection.service.ServiceComponent
import com.android.a2mvcdandagger.common.dependencyinjection.service.ServiceModule
import com.android.a2mvcdandagger.networking.StackoverflowApi
import dagger.Component
import javax.inject.Singleton

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {

    fun newActivityCompononent():ActivityComponent.Builder //todo 3 (next BaseActivity)
    fun newServiceCompononent(serviceModule: ServiceModule):ServiceComponent

}