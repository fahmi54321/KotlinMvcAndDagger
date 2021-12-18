package com.android.a2mvcdandagger.common.dependencyinjection.service

import android.app.Service
import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.android.a2mvcdandagger.common.dependencyinjection.app.AppComponent
import com.android.a2mvcdandagger.common.dependencyinjection.app.AppModule
import com.android.a2mvcdandagger.screens.common.navigator.ScreenNavigator
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

//todo 1 (next ServiceComponent)
@Module
class ServiceModule(
    val service: Service,
) {

    @Provides
    fun context(): Context = service
}